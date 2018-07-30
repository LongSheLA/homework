package com.advantech.homework.entity;

public class UserQuery {

    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户角色
     * 0：代表管理员
     * 1：代表普通用户
     */
    private String role;
    /**
     * 部门名称
     */
    private String departmentName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
