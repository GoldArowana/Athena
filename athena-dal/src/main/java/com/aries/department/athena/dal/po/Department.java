package com.aries.department.athena.dal.po;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Department {
    @Id
    private Long id;
    private String departmentName;
    private Long leaderId; //部门管理者，部长,
    private Long upId; //上级部门id
}
