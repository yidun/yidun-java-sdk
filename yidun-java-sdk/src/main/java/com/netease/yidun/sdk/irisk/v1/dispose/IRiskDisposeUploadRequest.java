package com.netease.yidun.sdk.irisk.v1.dispose;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Map;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/6 15:30
 */
public class IRiskDisposeUploadRequest extends BizPostJsonRequest<IRiskDisposeUploadResponse> {

    /**
     * 需要进行处置的对象的类型
     */
    @NotNull(message = "handleObjectType不能为空")
    private Integer handleObjectType;

    /**
     * 封禁/处置对象的ID
     */
    @NotEmpty(message = "objectId不能为空")
    @Length(max = 256, message = "objectId长度最大为256")
    private String objectId;

    /**
     * 如处置对象是属于某个账号下的某个角色，则请补充角色ID
     */
    @Length(max = 256, message = "roleId长度最大为256")
    private String roleId;

    /**
     * 封禁/处置的动作
     */
    @NotNull(message = "action不能为空")
    private Integer action;

    /**
     * 自定义内容，封禁/初始动作的详情说明
     */
    @Length(max = 512, message = "actionDes长度最大为512")
    private String actionDes;

    /**
     * 自定义内容，封禁/处置的原因
     */
    @Length(max = 256, message = "reason长度最大为512")
    private String reason;

    public IRiskDisposeUploadRequest(String businessId) {
        productCode = "irisk";
        version = "500";
        uriPattern = "/v5/disposeInfo/upload";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("objectId", objectId);
        customSignParams.put("roleId", roleId);
        if (action != null) {
            customSignParams.put("action", String.valueOf(action));
        }
        if (handleObjectType != null) {
            customSignParams.put("handleObjectType", String.valueOf(handleObjectType));
        }
        customSignParams.put("actionDes", actionDes);
        customSignParams.put("reason", reason);
        return customSignParams;
    }

    @Override
    public Class<IRiskDisposeUploadResponse> getResponseClass() {
        return IRiskDisposeUploadResponse.class;
    }

    public Integer getHandleObjectType() {
        return handleObjectType;
    }

    public void setHandleObjectType(Integer handleObjectType) {
        this.handleObjectType = handleObjectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getActionDes() {
        return actionDes;
    }

    public void setActionDes(String actionDes) {
        this.actionDes = actionDes;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
