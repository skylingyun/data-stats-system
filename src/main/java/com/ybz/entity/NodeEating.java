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
public class NodeEating {
    private Integer id;

    private String pk;

    private String userId;

    private Double money;

    private String company;

    private Integer personNum;

    private Date eatingDate;

    private Boolean valid;

    private String category;

    private Boolean expense;

    private String imagesystemtype;

    private Date ts;

    private Boolean overStandard;

    private String itemPk;

    private String itemName;

    private String szitemPk;

    private String szitemName;

    private Double reductionAmount;

    private String reductionInfo;

    private Date reductionTime;

    public Integer getId() {
        return id;
    }

}