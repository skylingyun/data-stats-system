package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class NodeCommunicate {
    private Integer id;

    private String pk;

    private String userId;

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

}