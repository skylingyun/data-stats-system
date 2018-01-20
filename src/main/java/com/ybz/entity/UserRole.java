package com.ybz.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UserRole {
    private Long id;

    private Long userId;

    private Long roleId;

}