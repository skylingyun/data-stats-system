package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/20.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class TenantInfo implements Serializable {

    private String tenantId; // 租户ID
    private String tenantName; // 租户名称
    private String openDate; // 开通日期
    private Integer usersNumber; // 开通总人数
    private Integer submitUsersNumber;  // 报销人数
    private String submitRadio; // 报销占比
    private String billsNumber; // 单据总数量
    private String billsMoney; // 单据总金额
    private String averageBillsNumber;  // 人均单据量
    private String approveNumber;   // 审批总数
    private String recordNumber;// 记账总数
}
