package com.aries.department.athena.dal.po;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class Partner {
    @Id
    private Integer id;
    private Integer companyId;
    private String companyName;
    private String password;
    private String keyword;
    private Date insertTime;
    private Date updateTime;
}
