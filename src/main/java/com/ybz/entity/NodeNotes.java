package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 所有记事字段
 *
 * @author zhangybt
 * @create 2017年08月13日 15:53
 **/
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class NodeNotes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tenantId;

    private String tenantName;

    private Integer travel;

    private Integer eating;

    private Integer gather;

    private Integer hotel;

    private Integer other;

    private Double travelMoney;

    private Double eatingMoney;

    private Double gatherMoney;

    private Double hotelMoney;

    private Double otherMoney;

    private Double totalMoney;

    private String beforeDay;

    private String afterDay;

}
