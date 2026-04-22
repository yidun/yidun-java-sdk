package com.netease.yidun.sdk.irisk.v6.check.v604;

import com.netease.yidun.sdk.irisk.v6.check.v602.HitInfoV602;
import com.netease.yidun.sdk.irisk.v6.check.v603.IRiskCheckV603Result;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.ip.IpRiskInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneBasicInfo;
import com.netease.yidun.sdk.irisk.v6.check.v603.phone.PhoneInfo;
import com.netease.yidun.sdk.irisk.v6.check.v604.phone.PhoneRiskInfoV604;

public class IRiskCheckV604Result extends IRiskCheckV603Result<HitInfoV602, PhoneInfo<PhoneBasicInfo, PhoneRiskInfoV604>, IpInfo<IpBasicInfo, IpRiskInfo>> {

}
