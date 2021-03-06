package com.gudao.generator.model;

import java.io.Serializable;

/**
 * 
 *
 * @author Gudao
 * @date   2021/03/06
 */
public class User implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户信息
     */
    private String userInfo;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 角色id
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userInfo=").append(userInfo);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}