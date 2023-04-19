package com.netease.yidun.sdk.auth.ocr.idcard.v1;

/**
 * 身份证OCR所得信息
 */
public class IdCardInfo {

    /**
     * 识别姓名
     */
    private String ocrName;

    /**
     * 识别身份证号
     */
    private String ocrCardNo;

    /**
     * 身份证过期时间
     */
    private String expireDate;

    /**
     * 性别
     */
    private String gender;

    /**
     * 名族
     */
    private String nation;

    /**
     * 出身日期
     */
    private String birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 发证机关
     */
    private String authority;

    public String getOcrName() {
        return ocrName;
    }

    public void setOcrName(String ocrName) {
        this.ocrName = ocrName;
    }

    public String getOcrCardNo() {
        return ocrCardNo;
    }

    public void setOcrCardNo(String ocrCardNo) {
        this.ocrCardNo = ocrCardNo;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "IdCardInfo(" +
                "ocrName=" + ocrName +
                ", ocrCardNo=" + ocrCardNo +
                ", expiryDate=" + expireDate +
                ", gender=" + gender +
                ", nation=" + nation +
                ", birthday=" + birthday +
                ", address=" + address +
                ", authority=" + authority +
                ")";
    }
}
