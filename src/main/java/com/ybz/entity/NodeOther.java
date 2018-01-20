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
public class NodeOther {
    private Integer id;

    private String pk;

    private String userId;

    private Double money;

    private Date otherDate;

    private Boolean expense;

    private Boolean valid;

    private Date ts;

    private Double taxrate;

    private Double includtax;

    private Double nottax;

    private String invoicenum;

    private String invoicetype;

    private String imagesystemtype;

}