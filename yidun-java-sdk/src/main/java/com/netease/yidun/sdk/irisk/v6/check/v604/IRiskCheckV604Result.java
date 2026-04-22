package com.netease.yidun.sdk.irisk.v6.check.v604;

import com.netease.yidun.sdk.irisk.v6.check.v602.HitInfoV602;
import com.netease.yidun.sdk.irisk.v6.check.v603.IRiskCheckV603Result;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneInfo;
import com.netease.yidun.sdk.irisk.v6.check.v604.account.AccountRiskInfo;
import com.netease.yidun.sdk.irisk.v6.check.v604.device.DeviceRiskInfo;
import com.netease.yidun.sdk.irisk.v6.check.v604.ip.IpRiskInfoV604;
import com.netease.yidun.sdk.irisk.v6.check.v604.phone.PhoneRiskInfoV604;

public class IRiskCheckV604Result extends IRiskCheckV603Result<HitInfoV602, PhoneInfo<PhoneBasicInfo, PhoneRiskInfoV604>, IpInfo<IpBasicInfo, IpRiskInfoV604>> {

    /**
     * 设备风险信息
     */
    private DeviceRiskInfo deviceRiskInfo;

    /**
     * 账号风险信息
     */
    private AccountRiskInfo accountRiskInfo;

    public DeviceRiskInfo getDeviceRiskInfo() {
        return deviceRiskInfo;
    }

    public void setDeviceRiskInfo(DeviceRiskInfo deviceRiskInfo) {
        this.deviceRiskInfo = deviceRiskInfo;
    }

    public AccountRiskInfo getAccountRiskInfo() {
        return accountRiskInfo;
    }

    public void setAccountRiskInfo(AccountRiskInfo accountRiskInfo) {
        this.accountRiskInfo = accountRiskInfo;
    }

    @Override
    public String toString() {
        return "IRiskCheckV604Result{" +
                "super=" + super.toString() +
                ", deviceRiskInfo=" + deviceRiskInfo +
                ", accountRiskInfo=" + accountRiskInfo +
                '}';
    }
}
