
package com.netease.yidun.sdk.auth.ocr.bankcard.v1;


/**
 * 银行卡OCR所得信息
 */
public class BankCardInfo {

    /**
     * 银行卡号
     */
    private String bankCardNumber;
    /**
     * 有效期
     */
    private String validDate;
    /**
     * 银行类型
     */
    private int bankCardType;
    /**
     * 银行名称
     */
    private String bankName;

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public int getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(int bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "BankCardInfo(" +
                "bankCardNumber=" + bankCardNumber +
                ", validDate=" + validDate +
                ", bankCardType=" + bankCardType +
                ", bankName=" + bankName +
                ')';
    }
}
