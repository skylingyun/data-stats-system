package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userid;

    private String userName;

    private String password;

    private Date birthday;

    private Date registerdate;

    private String location;

    private String company;

    private String email;

    private String phone;

    private String telnum;

    private String avatar;

    private String association;

    private String deptpk;

    private String deptname;

    private String userCode;

    private Date ts;

    private Boolean dr;

    private String postpk;

    private String postname;

    private String rankpk;

    private String rankname;

    private String deptcode;

    private String description;

}