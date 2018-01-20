package com.ybz.entity;

import java.util.Date;

public class SysTenant {
    private Long id;

    private String tenantId;

    private String tenantName;

    private String tenantCode;

    private String tenantAddress;

    private String tenantTel;

    private String tenantEmail;

    private String tenantFullname;

    private Date createTime;

    private Date ts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName == null ? null : tenantName.trim();
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode == null ? null : tenantCode.trim();
    }

    public String getTenantAddress() {
        return tenantAddress;
    }

    public void setTenantAddress(String tenantAddress) {
        this.tenantAddress = tenantAddress == null ? null : tenantAddress.trim();
    }

    public String getTenantTel() {
        return tenantTel;
    }

    public void setTenantTel(String tenantTel) {
        this.tenantTel = tenantTel == null ? null : tenantTel.trim();
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail == null ? null : tenantEmail.trim();
    }

    public String getTenantFullname() {
        return tenantFullname;
    }

    public void setTenantFullname(String tenantFullname) {
        this.tenantFullname = tenantFullname == null ? null : tenantFullname.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}