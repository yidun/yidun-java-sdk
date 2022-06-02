

package com.netease.yidun.sdk.core.endpoint;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.utils.StringUtils;

public class EndpointConfigLoader {

    private static final String CONFIG_FILE_NAME = "yidun_regional_endpoints.json";

    /**
     * 从资源目录下的配置文件 yidun_regional_endpoints.json 中载入域名配置信息。
     * 如果存在多个同名文件，则将合并（去重）它们的内容。
     * @formatter:off
     * key: product code
     * value:
     *     key: region code
     *     value: domain list
     * @formatter:on
     * */
    public static Map<String, Map<String, List<String>>> loadFromResourceFiles() {
        Enumeration<URL> resources;
        try {
            resources = EndpointConfigLoader.class.getClassLoader().getResources(CONFIG_FILE_NAME);
        } catch (IOException e) {
            throw new YidunSdkException("Fail to get domain config resource " + CONFIG_FILE_NAME, e);
        }

        return load(resources);
    }

    /**
     * 从配置文件载入域名配置信息。此方法会合并（去重）目标配置文件的内容。
     * @param configFileUrls 各配置文件的路径
     * @formatter:off
     * key: product code
     * value:
     *     key: region code
     *     value: domain list
     * @formatter:on
     * */
    public static Map<String, Map<String, List<String>>> load(Enumeration<URL> configFileUrls) {
        Map<String, Map<String, List<String>>> domainMap = new HashMap<>();

        while (configFileUrls.hasMoreElements()) {
            List<EndpointConfigEntry> entries = parseConfig(configFileUrls.nextElement());
            mergeConfig(domainMap, entries);
        }

        return domainMap;
    }

    /**
     * 将新配置合并（去重）到已有映射表中。新的域名会追加到原列表末尾
     */
    public static void mergeConfig(
            Map<String, Map<String, List<String>>> existingDomainMap,
            Collection<EndpointConfigEntry> newEntries) {
        mergeConfig(existingDomainMap, newEntries, false);
    }

    /**
     * 将新配置合并（去重）到已有映射表中
     * 
     * @param newDomainFirst 是否将新域名添加到原列表头部
     */
    public static void mergeConfig(
            Map<String, Map<String, List<String>>> existingDomainMap,
            Collection<EndpointConfigEntry> newEntries,
            boolean newDomainFirst) {
        for (EndpointConfigEntry entry : newEntries) {
            // key: region code; value: domain list
            String productCode = entry.productCode();
            String regionCode = entry.getRegionCode();
            List<String> newDomains = entry.domains();

            Map<String, List<String>> regionDomainMap = existingDomainMap.computeIfAbsent(
                    productCode, pc -> new HashMap<>());

            List<String> existingDomains = regionDomainMap.computeIfAbsent(
                    regionCode, rc -> new ArrayList<>());

            if (newDomainFirst) {
                List<String> mergedDomains = new ArrayList<>(newDomains);
                for (String domain : existingDomains) {
                    if (!mergedDomains.contains(domain)) {
                        mergedDomains.add(domain);
                    }
                }
                regionDomainMap.put(regionCode, mergedDomains);
            } else {
                for (String domain : newDomains) {
                    if (!existingDomains.contains(domain)) {
                        existingDomains.add(domain);
                    }
                }
            }
        }
    }

    private static List<EndpointConfigEntry> parseConfig(URL configUrl) {
        String strConfig = readAsString(configUrl);
        return parseConfigContent(strConfig);
    }

    private static List<EndpointConfigEntry> parseConfigContent(String configContent) {
        if (StringUtils.isBlank(configContent)) {
            return Collections.emptyList();
        }

        List<EndpointConfigEntry> items = new ArrayList<>();
        try {
            JsonObject root = JsonParser.parseString(configContent).getAsJsonObject();
            for (Map.Entry<String, JsonElement> prodEntry : root.entrySet()) {
                String productCode = prodEntry.getKey();

                for (Map.Entry<String, JsonElement> regionEntry : prodEntry.getValue().getAsJsonObject().entrySet()) {
                    String regionCode = regionEntry.getKey();

                    JsonArray domainArray = regionEntry.getValue().getAsJsonArray();
                    List<String> domains = new ArrayList<>(domainArray.size());
                    for (JsonElement e : domainArray) {
                        String domain = e.getAsString();
                        if (StringUtils.isNotBlank(domain)) {
                            domains.add(domain);
                        }
                    }

                    items.add(new EndpointConfigEntry(productCode, regionCode, domains));
                }
            }
        } catch (Exception e) {
            // ignore
        }

        return items;
    }

    private static String readAsString(URL url) {
        try {
            try (InputStreamReader reader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)) {
                StringBuilder sb = new StringBuilder();
                char[] buffer = new char[1024 * 4];
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    sb.append(buffer, 0, n);
                }

                return sb.toString();
            }
        } catch (IOException e) {
            // ignore
            return null;
        }
    }
}
