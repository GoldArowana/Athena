package com.aries.department.athena.dal.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Staff {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname; //全名
    private String aliasName;//别名
    private Short sex;//性别。0表示未设置。1表示男。2表示女。
    private String email;
    private String phone;
    private String qq;
    private String wechat;
    private String jobLevel;//职级
    private Integer jobGroup;//职位类别。如"后台开发"
    private Boolean onJob;//是否在职
    private Integer departmentId;//所属部门id
    private Short countryId;//国家编码。
    private Integer cityId;//城市id
    private String gaeaAccount;//员工账号
    private String employeeId;//员工号
    private Integer identityId;//身份id。对应身份表里的身份信息。在中国指的是身份证相关信息。
    private String address;//现住址
    private Date joinTime;//入职时间
}
