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
public class NcInfo {
    private Integer id;

    private String pk;

    private String userid;

    private String ip;

    private String port;

    private String ds;

    private String tokenseed;

    private String maip;

    private String maport;

    private Date ts;

    private String ostype;

    private String osparam;

    private String bpmtenantid;

    private String version;

    private String bpmtenantpid;

    private Byte syncuser;

    private Byte sendemail;

    private Byte isshowswitchorg;

}