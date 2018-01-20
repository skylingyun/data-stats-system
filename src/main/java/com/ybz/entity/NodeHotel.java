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
public class NodeHotel {
    private Integer id;

    private String pk;

    private String userId;

    private Double money;

    private String city;

    private Date startDate;

    private Date endDate;

    private String hotel;

    private Boolean expense;

    private Boolean valid;

    private Date ts;

    private Double taxrate;

    private Double includtax;

    private Double nottax;

    private String invoicenum;

    private String demo1;

    private String imagesystemtype;

}