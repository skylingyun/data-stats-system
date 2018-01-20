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
public class NcUser {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String pk;

    private String userid;

    private String parent;

    private String usercode;

    private String userpk;

    private String password;

    private Boolean valid;

    private Date ts;

    private String deptpk;

    private String deptname;

    private String orgpk;

    private String orgname;

    private String pcode;

    private String passengerid;

    private String fatherdeptpk;

    private String fatherdeptname;

}