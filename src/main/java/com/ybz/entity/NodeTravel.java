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
public class NodeTravel {
    private Integer id;

    private String pk;

    private String userId;

    private Double money;

    private String fromCity;

    private String toCity;

    private Date travelDate;

    private String travelWay;

    private Boolean expense;

    private Boolean valid;

    private String imagesystemtype;

    private String category;

    private Date ts;

    private String expensetype;

    private Boolean overStandard;

    private String seat;

    private String seatpk;

    private Date startDate;

    private Date endDate;

    private String itemPk;

    private String itemName;

    private String szitemPk;

    private String szitemName;

    private Double reductionAmount;

    private String reductionInfo;

    private Date reductionTime;

}