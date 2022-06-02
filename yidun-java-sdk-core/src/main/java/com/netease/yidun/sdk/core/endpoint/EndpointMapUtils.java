

package com.netease.yidun.sdk.core.endpoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EndpointMapUtils {

    private static final String FLAT_KEY_FORMAT = "%s:%s";

    /**
     * 将域名的索引（product code + region code）组合成单个字符串，方便查找。
     *
     * 新索引字符串由 {@link #genDomainKey(String, String)} 生成。
     *
     * @return key: 新索引字符串; value: domain list
     */
    public static Map<String, List<String>> flatKey(Map<String, Map<String, List<String>>> existingDomainMap) {
        Map<String, List<String>> result = new HashMap<>();

        for (Map.Entry<String, Map<String, List<String>>> entry : existingDomainMap.entrySet()) {
            String productCode = entry.getKey();

            for (Map.Entry<String, List<String>> regionDomainMap : entry.getValue().entrySet()) {
                String regionCode = regionDomainMap.getKey();
                String flatKey = genDomainKey(productCode, regionCode);
                result.put(flatKey, regionDomainMap.getValue());
            }
        }

        return result;
    }

    /**
     * 组合 product code 和 region code，生成一个字符串，可作为域名映射表的索引
     */
    public static String genDomainKey(String productCode, String regionCode) {
        return String.format(FLAT_KEY_FORMAT, productCode, regionCode);
    }
}
