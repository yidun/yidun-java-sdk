

package com.netease.yidun.sdk.core.endpoint;

import static com.netease.yidun.sdk.core.endpoint.EndpointConfigLoader.loadFromResourceFiles;
import static com.netease.yidun.sdk.core.endpoint.EndpointConfigLoader.mergeConfig;
import static com.netease.yidun.sdk.core.endpoint.EndpointMapUtils.flatKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 复合型域名配置——用户显式指定域名 结合 本地域名配置文件。提供的域名列表中，用户指定的域名在前，本地配置文件提供的域名在后
 */
public class CompoundEndpointResolver extends AbstractEndpointResolver {

    public CompoundEndpointResolver(String productCode, String regionCode, String domain) {
        this(productCode, regionCode, Collections.singletonList(domain));
    }

    public CompoundEndpointResolver(String productCode, String regionCode, Collection<String> domains) {
        this(new EndpointConfigEntry()
                .productCode(productCode)
                .regionCode(regionCode)
                .domains(new ArrayList<>(domains)));
    }

    public CompoundEndpointResolver(EndpointConfigEntry configEntry) {
        this(Collections.singleton(configEntry));
    }

    public CompoundEndpointResolver(Collection<EndpointConfigEntry> configEntries) {
        super(assembleDomainMap(configEntries));
    }

    private static Map<String, List<String>> assembleDomainMap(Collection<EndpointConfigEntry> configEntries) {
        Map<String, Map<String, List<String>>> tmpMap = loadFromResourceFiles();
        mergeConfig(tmpMap, configEntries, true);
        return flatKey(tmpMap);
    }
}
