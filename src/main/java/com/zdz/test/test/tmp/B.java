package com.zdz.test.test.tmp;

public class B {

    /**
     * id : 借款单的长整型唯一键
     * userId : 借款用户的长整型唯一键
     * businessType : 业务类型：枚举（0-现金分期）
     * channelId : 申请渠道ID
     * channelName : 申请渠道
     * fundingCorp : 资金方
     * fundingName : 资金方名称
     * loanAmount : 合同贷款金额（单位：元）：BigDecimal（0.000000）
     * principaInterestService : 总本息服（单位：元）：BigDecimal（0.000000）
     * term : 总分期数：1～n正整数
     * bankName : 银行名称
     * bankCard : 银行卡号
     * cardConfirmDateTime : 绑卡时间（yyyy-MM-dd hh:mm:ss）
     * applyTime : 申请时间（yyyy-MM-dd hh:mm:ss）
     * loanPaidAt : 放款时间（yyyy-MM-dd hh:mm:ss）
     */

    private String id;
    private String userId;
    private String businessType;
    private String channelId;
    private String channelName;
    private String fundingCorp;
    private String fundingName;
    private String loanAmount;
    private String principaInterestService;
    private String term;
    private String bankName;
    private String bankCard;
    private String cardConfirmDateTime;
    private String applyTime;
    private String loanPaidAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getFundingCorp() {
        return fundingCorp;
    }

    public void setFundingCorp(String fundingCorp) {
        this.fundingCorp = fundingCorp;
    }

    public String getFundingName() {
        return fundingName;
    }

    public void setFundingName(String fundingName) {
        this.fundingName = fundingName;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getPrincipaInterestService() {
        return principaInterestService;
    }

    public void setPrincipaInterestService(String principaInterestService) {
        this.principaInterestService = principaInterestService;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getCardConfirmDateTime() {
        return cardConfirmDateTime;
    }

    public void setCardConfirmDateTime(String cardConfirmDateTime) {
        this.cardConfirmDateTime = cardConfirmDateTime;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getLoanPaidAt() {
        return loanPaidAt;
    }

    public void setLoanPaidAt(String loanPaidAt) {
        this.loanPaidAt = loanPaidAt;
    }
}
