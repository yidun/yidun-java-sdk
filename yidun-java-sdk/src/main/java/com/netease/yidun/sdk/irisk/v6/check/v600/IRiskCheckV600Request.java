package com.netease.yidun.sdk.irisk.v6.check.v600;

import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.v600.hitinfo.HitInfo;

public class IRiskCheckV600Request extends IRiskCheckV600PureRequest<DataResponse<IRiskCheckV600Result<HitInfo>>> {
    
    /**
     * 用户/玩家的角色的服务器名称
     */
    private String server;

    /**
     * 活动操作的目标，比如：A给B点赞，则target为B。如果target是手机号或邮箱，请提供hash值，hash算法：md5(target)。如没有，可传空
     */
    private String target;

    /**
     * 游戏类型应用的版本号
     */
    private String gameVersion;

    /**
     * 游戏类型应用的资源版本号
     */
    private String assetVersion;

    public IRiskCheckV600Request(String businessId) {
        productCode = "irisk";
        version = "600";
        uriPattern = "/v6/risk/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("server", server);
        customSignParams.put("target", target);
        customSignParams.put("gameVersion", gameVersion);
        customSignParams.put("assetVersion", assetVersion);
        return customSignParams;
    }

    @Override
    public Class<DataResponse<IRiskCheckV600Result<HitInfo>>> getResponseClass() {
        return null;
    }

    @Override
    public java.lang.reflect.Type getResponseType() {
        return new TypeToken<DataResponse<IRiskCheckV600Result<HitInfo>>>() {}.getType();
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getAssetVersion() {
        return assetVersion;
    }

    public void setAssetVersion(String assetVersion) {
        this.assetVersion = assetVersion;
    }

    @Override
    public String toString() {
        return "IRiskCheckV600Request(" +
                "super=" + super.toString() +
                ", server=" + server +
                ", target=" + target +
                ", gameVersion=" + gameVersion +
                ", assetVersion=" + assetVersion +
                ")";
    }

}
