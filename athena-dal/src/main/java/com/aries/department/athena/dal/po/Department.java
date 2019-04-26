package com.aries.department.athena.dal.po;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Department {
    @Id
    private Integer id;
    private String departmentName;
    private Integer leaderId; //部门管理者，部长,
    private Integer upId; //上级部门id
}
