package com.aries.department.athena.service.thrift.util;

import com.aries.department.athena.bll.PartnerBll;
import com.aries.department.athena.bll.bean.CompanyBean;
import com.aries.department.athena.contract.thrift.dto.AthenaResponse;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import static com.aries.department.athena.service.thrift.constant.AthenaResponseEnum.NO_PERMISSION;

@Getter
public class CompanyHelper {
    private boolean error;
    private CompanyInfo companyInfo;
    private String databaseName;
    private AthenaResponse response;

    public CompanyHelper(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public CompanyHelper invoke() {
        CompanyBean companyBean = new CompanyBean(companyInfo.getName(), companyInfo.getPassword(), companyInfo.getKeyword());
        databaseName = PartnerBll.getDatabase(companyBean);

        if (StringUtils.isBlank(databaseName)) {
            response = NO_PERMISSION.of();
            error = true;
            return this;
        }

        error = false;
        response = new AthenaResponse();
        return this;
    }
}