package com.ybz.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OcsCommunicate {
    private Integer id;

    private String pk;

    private String userId;

    private String tenantId;

    private String phoneNumber;

    private BigDecimal money;

    private String communicateType;

    private Date communicateDate;

    private Boolean expense;

    private Boolean valid;

    private Date ts;

    private Date communicateStart;

    private Date communicateEnd;

    private String category;

    private String imagesystemtype;

    private Boolean overStandard;

    private String itemPk;

    private String itemName;

    private String szitemPk;

    private String szitemName;

    private Double reductionAmount;

    private String reductionInfo;

    private Date reductionTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk == null ? null : pk.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCommunicateType() {
        return communicateType;
    }

    public void setCommunicateType(String communicateType) {
        this.communicateType = communicateType == null ? null : communicateType.trim();
    }

    public Date getCommunicateDate() {
        return communicateDate;
    }

    public void setCommunicateDate(Date communicateDate) {
        this.communicateDate = communicateDate;
    }

    public Boolean getExpense() {
        return expense;
    }

    public void setExpense(Boolean expense) {
        this.expense = expense;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Date getCommunicateStart() {
        return communicateStart;
    }

    public void setCommunicateStart(Date communicateStart) {
        this.communicateStart = communicateStart;
    }

    public Date getCommunicateEnd() {
        return communicateEnd;
    }

    public void setCommunicateEnd(Date communicateEnd) {
        this.communicateEnd = communicateEnd;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getImagesystemtype() {
        return imagesystemtype;
    }

    public void setImagesystemtype(String imagesystemtype) {
        this.imagesystemtype = imagesystemtype == null ? null : imagesystemtype.trim();
    }

    public Boolean getOverStandard() {
        return overStandard;
    }

    public void setOverStandard(Boolean overStandard) {
        this.overStandard = overStandard;
    }

    public String getItemPk() {
        return itemPk;
    }

    public void setItemPk(String itemPk) {
        this.itemPk = itemPk == null ? null : itemPk.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getSzitemPk() {
        return szitemPk;
    }

    public void setSzitemPk(String szitemPk) {
        this.szitemPk = szitemPk == null ? null : szitemPk.trim();
    }

    public String getSzitemName() {
        return szitemName;
    }

    public void setSzitemName(String szitemName) {
        this.szitemName = szitemName == null ? null : szitemName.trim();
    }

    public Double getReductionAmount() {
        return reductionAmount;
    }

    public void setReductionAmount(Double reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    public String getReductionInfo() {
        return reductionInfo;
    }

    public void setReductionInfo(String reductionInfo) {
        this.reductionInfo = reductionInfo == null ? null : reductionInfo.trim();
    }

    public Date getReductionTime() {
        return reductionTime;
    }

    public void setReductionTime(Date reductionTime) {
        this.reductionTime = reductionTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}