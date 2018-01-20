package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class NodeExpense {
    private Integer id;

    private String pk;

    private String userid;

    private Date expenseDate;

    private Double money;

    private Date ts;

    private String djlxpk;

    private Integer billstatus;

    private String billtypecode;

    private String billtypename;

    private String pkBill;

    private Date dealdate;

    private Boolean valid;

    private String zdyhead;

    private String zdyheadvalue;

    private String bankaccountkey;

    private String bankaccount;

    private String szitemkey;

    private String szitemvalue;

    private String requisitionkey;

    private String requisition;

    private String defitem1;

    private String defitem2;

    private String defitem3;

    private String defitem4;

    private String defitem5;

    private String defitem6;

    private String defitem7;

    private String defitem8;

    private String defitem9;

    private String defitem10;

    private Boolean overStandard;

}