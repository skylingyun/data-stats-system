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
public class ManagerUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private transient String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;

    /**
     * 创建时间
     */
    private Date createTime;

}