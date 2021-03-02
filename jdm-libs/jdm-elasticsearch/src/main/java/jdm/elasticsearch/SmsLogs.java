/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdm.elasticsearch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class SmsLogs {

    @JsonIgnore
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendDate;
    private String longCode;
    private String mobile;
    private String corpName;
    private String smsContent;
    private int state;
    private int operatorId;
    private String province;
    private String ipAddr;
    private int replyTotal;
    private int fee;

    public SmsLogs() {
    }

    public SmsLogs(
            String id, Date createDate, Date sendDate,
            String longCode, String mobile, String corpName,
            String smsContent, int state, int operatorId,
            String province, String ipAddr,
            int replyTotal, int fee) {
        this.id = id;
        this.createDate = createDate;
        this.sendDate = sendDate;
        this.longCode = longCode;
        this.mobile = mobile;
        this.corpName = corpName;
        this.smsContent = smsContent;
        this.state = state;
        this.operatorId = operatorId;
        this.province = province;
        this.ipAddr = ipAddr;
        this.replyTotal = replyTotal;
        this.fee = fee;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the value of createDate
     *
     * @return the value of createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Set the value of createDate
     *
     * @param createDate new value of createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Get the value of sendDate
     *
     * @return the value of sendDate
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * Set the value of sendDate
     *
     * @param sendDate new value of sendDate
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * Get the value of longCode
     *
     * @return the value of longCode
     */
    public String getLongCode() {
        return longCode;
    }

    /**
     * Set the value of longCode
     *
     * @param longCode new value of longCode
     */
    public void setLongCode(String longCode) {
        this.longCode = longCode;
    }

    /**
     * Get the value of mobile
     *
     * @return the value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set the value of mobile
     *
     * @param mobile new value of mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Get the value of corpName
     *
     * @return the value of corpName
     */
    public String getCorpName() {
        return corpName;
    }

    /**
     * Set the value of corpName
     *
     * @param corpName new value of corpName
     */
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    /**
     * Get the value of smsContent
     *
     * @return the value of smsContent
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * Set the value of smsContent
     *
     * @param smsContent new value of smsContent
     */
    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }

    /**
     * Get the value of state
     *
     * @return the value of state
     */
    public int getState() {
        return state;
    }

    /**
     * Set the value of state
     *
     * @param state new value of state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * Get the value of operatorId
     *
     * @return the value of operatorId
     */
    public int getOperatorId() {
        return operatorId;
    }

    /**
     * Set the value of operatorId
     *
     * @param operatorId new value of operatorId
     */
    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * Get the value of province
     *
     * @return the value of province
     */
    public String getProvince() {
        return province;
    }

    /**
     * Set the value of province
     *
     * @param province new value of province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Get the value of ipAddr
     *
     * @return the value of ipAddr
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * Set the value of ipAddr
     *
     * @param ipAddr new value of ipAddr
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    /**
     * Get the value of replyTotal
     *
     * @return the value of replyTotal
     */
    public int getReplyTotal() {
        return replyTotal;
    }

    /**
     * Set the value of replyTotal
     *
     * @param replyTotal new value of replyTotal
     */
    public void setReplyTotal(int replyTotal) {
        this.replyTotal = replyTotal;
    }

    /**
     * Get the value of fee
     *
     * @return the value of fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * Set the value of fee
     *
     * @param fee new value of fee
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

}
