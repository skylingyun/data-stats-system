package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Config {
    private Long id;

    private String key;

    private String value;

    private Byte status;

    private String remark;
}