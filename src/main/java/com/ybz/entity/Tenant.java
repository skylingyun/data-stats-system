package com.ybz.entity;

import com.ybz.annotation.ExcelAnno;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 租户信息
 *
 * @author zhangybt
 * @create 2017年08月01日 19:37
 **/
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Tenant implements Serializable {

    private String tenantId;
    private String tenantName;
    private String tenantAddress;
    private String tenantEmail;
    private String tenantFullname;
    private String tenantTel;
    private String isLocal;//判断是不是本地租户,0为是
    private String createTime;
    private String userNum;
    private Integer userCount;
    private Integer reimburseCount;
    private Integer billCount;
    private Double  billMoney;
    private Integer noteCount;
    private Integer thirdCount;
    private Integer approveCount;
    private Integer totalBillCount;
    private Integer reimburseTotalCount;
    private Integer expenseCount;
    private Double reimburseProportion;
    private Double personProportion;

}
