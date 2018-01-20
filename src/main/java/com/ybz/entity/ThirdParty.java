package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/20.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ThirdParty implements Serializable {
    private String tenantId;
    private String tenantName;
    private Integer serviceProviderCount;
    private Integer orderCount;
    private Double orderMoney;
    private Integer noteCount;
    private Integer reimburseNoteCount;
    private Double reimburseNoteMoney;
    private Integer tenantCount;
}
