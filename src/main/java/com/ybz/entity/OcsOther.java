package com.ybz.entity;

import java.util.Date;

public class OcsOther {
    private Integer id;

    private String pk;

    private String userId;

    private String tenantId;

    private Double money;

    private Date otherDate;

    private Boolean expense;

    private Boolean valid;

    private String category;

    private Date ts;

    private Double taxrate;

    private Double includtax;

    private Double nottax;

    private String invoicenum;

    private String invoicetype;

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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getOtherDate() {
        return otherDate;
    }

    public void setOtherDate(Date otherDate) {
        this.otherDate = otherDate;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Double getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Double taxrate) {
        this.taxrate = taxrate;
    }

    public Double getIncludtax() {
        return includtax;
    }

    public void setIncludtax(Double includtax) {
        this.includtax = includtax;
    }

    public Double getNottax() {
        return nottax;
    }

    public void setNottax(Double nottax) {
        this.nottax = nottax;
    }

    public String getInvoicenum() {
        return invoicenum;
    }

    public void setInvoicenum(String invoicenum) {
        this.invoicenum = invoicenum == null ? null : invoicenum.trim();
    }

    public String getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype == null ? null : invoicetype.trim();
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