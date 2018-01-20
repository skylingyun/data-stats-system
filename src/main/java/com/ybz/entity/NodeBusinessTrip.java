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
public class NodeBusinessTrip {
    private Integer id;

    private String pk;

    private String userId;

    private Double money;

    private String city;

    private String zdyhead;

    private String zdyheadvalue;

    private String descript;

    private Date startDate;

    private Date endDate;

    private Date ts;

    private Integer billstatus;

    private Integer reimburstatus;

    private String pkBill;

    private Date dealdate;

    private Boolean valid;

    private String tagpk;

    private Boolean isClosed;

    private Double budgetMoney;

    private Double restMoney;

    private Double usedMoney;

    private String matter;

    private String costProject;

    private String djdl;

    private String djlxbm;

    private String billtype;

    private String djlxpk;

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

    private String errormsg;

}