

package com.netease.yidun.sdk.core.endpoint;

import static com.netease.yidun.sdk.core.endpoint.EndpointMapUtils.genDomainKey;

import java.util.List;
import java.util.Map;

import com.netease.yidun.sdk.core.exception.YidunSdkException;

public abstract class AbstractEndpointResolver implements EndpointResolver {

    protected final Map<String, List<String>> domainMap;

    protected AbstractEndpointResolver(Map<String, List<String>> domainMap) {
        this.domainMap = domainMap;
    }

    @Override
    public List<String> resolve(String productCode, String regionCode) throws YidunSdkException {
        String domainKey = genDomainKey(productCode, regionCode);
        List<String> domains = domainMap.get(domainKey);

        if (domains == null) {
            throw new YidunSdkException(
                    String.format("No available domain. productCode=%s, regionCode=%s", productCode, regionCode));
        }

        return domains;
    }
}
