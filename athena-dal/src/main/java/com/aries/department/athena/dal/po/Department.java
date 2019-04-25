package com.aries.department.athena.dal.po;

import javax.persistence.Id;

public class Department {
    @Id
    private Integer id;
    private String department_name;
    private Integer leader_id; //部门管理者，部长,
    private Integer up_id; //上级部门id
}
