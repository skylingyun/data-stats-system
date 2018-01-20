package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UserVo {
    private Integer id;

    private String userId;

    private String tenantId;

    private String userName;

    private String userEmail;

    private String userCode;

    private String userAvator;

    private String userMobile;

    private String needMerge;

    private String verified;

    private String validateEmail;

    private String userPassword;

    private String sysId;

    private String registerDate;

    private String userActivate;

    private String typeId;

    private String loginTs;

    private String para1;

    private String para2;

    private String para3;

    private String para4;

    private String source;

}