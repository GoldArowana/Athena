package com.aries.department.athena.bll;

import com.aries.department.athena.bll.bean.CompanyBean;
import com.aries.department.athena.dal.repository.PartnerRepository;

public class PartnerBll {
    public static String getDatabase(CompanyBean company) {
        return PartnerRepository.getDbNameByPassword(company.getName(), company.getPassword());
    }

}
