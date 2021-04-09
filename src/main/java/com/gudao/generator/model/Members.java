package com.gudao.generator.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: Programmer
 * @DateFormat: 2021/04/09
 * @Description: 
 */
@Data
@ToString
@ApiModel(value="Members")
public class Members implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id", name="id",dataType="String")
    private String id;

    /**
     * 部门ID
     */
    @ApiModelProperty(value="部门ID", name="departmentId",dataType="String")
    private String departmentId;

    /**
     * 登陆账号
     */
    @ApiModelProperty(value="登陆账号", name="loginName",dataType="String")
    private String loginName;

    /**
     * 用户名称
     */
    @ApiModelProperty(value="用户名称", name="userName",dataType="String")
    private String userName;

    /**
     * 邮箱
     */
    @ApiModelProperty(value="邮箱", name="email",dataType="String")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号", name="phonenumber",dataType="String")
    private String phonenumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty(value="用户性别（0男 1女 2未知）", name="sex",dataType="String")
    private String sex;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码", name="password",dataType="String")
    private String password;

    /**
     * 盐加密
     */
    @ApiModelProperty(value="盐加密", name="salt",dataType="String")
    private String salt;

    /**
     * 用户唯一授权码
     */
    @ApiModelProperty(value="用户唯一授权码", name="authCode",dataType="String")
    private String authCode;

    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty(value="帐号状态（0正常 1停用）", name="status",dataType="String")
    private String status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间", name="createTime",dataType="Date")
    private Date createTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value="创建者", name="createUser",dataType="String")
    private String createUser;

    /**
     * 创建人id
     */
    @ApiModelProperty(value="创建人id", name="createUserId",dataType="String")
    private String createUserId;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间", name="updateTime",dataType="Date")
    private Date updateTime;

    /**
     * 编辑人id
     */
    @ApiModelProperty(value="编辑人id", name="updateUserId",dataType="String")
    private String updateUserId;

    /**
     * 更新者
     */
    @ApiModelProperty(value="更新者", name="updateUser",dataType="String")
    private String updateUser;

    /**
     * 登陆次数
     */
    @ApiModelProperty(value="登陆次数", name="loginCount",dataType="Integer")
    private Integer loginCount;

    /**
     * 最近登陆时间
     */
    @ApiModelProperty(value="最近登陆时间", name="loginDate",dataType="Date")
    private Date loginDate;

    /**
     * 忘记密码状态  0为有效，1为失效
     */
    @ApiModelProperty(value="忘记密码状态  0为有效，1为失效", name="forgotStatus",dataType="Byte")
    private Byte forgotStatus;

    /**
     * 人员有效状态  0为有效，1为删除
     */
    @ApiModelProperty(value="人员有效状态  0为有效，1为删除", name="removeStatus",dataType="Byte")
    private Byte removeStatus;

    /**
     * 忘记密码有效修改时间
     */
    @ApiModelProperty(value="忘记密码有效修改时间", name="forgotEndTime",dataType="Date")
    private Date forgotEndTime;

    /**
     * 系统默认角色
     */
    @ApiModelProperty(value="系统默认角色", name="systemRole",dataType="String")
    private String systemRole;

    private static final long serialVersionUID = 1L;
}