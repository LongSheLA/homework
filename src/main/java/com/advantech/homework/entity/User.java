package com.advantech.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user_info")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User extends IdEntity implements Serializable {
    private static final long serialVersionUID = 4603642343377807741L;
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
    /**
     * 科室名称
     */
    private String  sectionName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 该用户下的所有设备
     *
     * 关系维护端，负责多对多关系的绑定和解除
     *  @JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
     *  inverseJoinColumns指定外键的名字，要关联的关系被维护端(device)
     *  其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
     *  即表名为user_device
     *  关联到主表的外键名：主表名+下划线+主表中的主键列名,device
     *  关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即device_id
     *  主表就是关系维护端对应的表，从表就是关系被维护端对应的表
     */
    private List<Device> deviceList;

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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_DEVICE", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "DEVICE_ID", referencedColumnName = "ID")})
    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
