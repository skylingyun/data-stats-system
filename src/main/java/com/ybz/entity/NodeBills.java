package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 单据类型vo
 *
 * @author zhangybt
 * @create 2017年08月14日 10:05
 **/
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class NodeBills implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tenantId;

    private String tenantName;

    private Integer businessTripCount;

    private Double businessTripMoney;

    private Integer expenseCount;

    private Double expenseMoney;

    private Integer loanBillCount;

    private Double loanBillMoney;

    private Integer totalCount;

    private Double totalMoney;

    private String time;

    private String endDate;//在生成报表时使用该日期显示

}
