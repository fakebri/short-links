package com.bri.shortlinks.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 用户表;
 *
 * @author : bri
 * @date : 2023-11-16
 */
@ApiModel(value = "用户表", description = "")
public class SlUser implements Serializable, Cloneable {
    /**
     * 用户编号
     */
    @ApiModelProperty(name = "用户编号", notes = "")
    private Integer userId;
    /**
     * 用户名称
     */
    @ApiModelProperty(name = "用户名称", notes = "")
    private String userName;
    /**
     * 用户密码
     */
    @ApiModelProperty(name = "用户密码", notes = "")
    private String password;

    /**
     * 用户编号
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * 用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户名称
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 用户密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}