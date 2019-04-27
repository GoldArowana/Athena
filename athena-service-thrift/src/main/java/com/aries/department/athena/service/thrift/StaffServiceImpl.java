package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.dto.AthenaResponse;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.dto.Staff;
import com.aries.department.athena.contract.thrift.service.StaffService;
import com.aries.department.athena.service.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;

@Slf4j
public class StaffServiceImpl implements StaffService.Iface {
    @Override
    public String ping() throws TException {
        log.debug("staff pong- -.");
        return "i am staff service";
    }

    @Override
    public AthenaResponse addStaff(CompanyInfo companyInfo, Staff staff) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError() || StringUtils.isBlank(companyHelper.getDatabaseName())) {
            return companyHelper.getResponse();
        }


        return null;
    }

    @Override
    public Staff getStaffById(CompanyInfo companyInfo, int id) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError() || StringUtils.isBlank(companyHelper.getDatabaseName())) {
            return null;
        }


        return null;
    }

    @Override
    public List<Staff> getStaffByName(CompanyInfo companyInfo, String name) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError() || StringUtils.isBlank(companyHelper.getDatabaseName())) {
            return Collections.emptyList();
        }


        return null;
    }

    @Override
    public List<Staff> getStaffByPinyin(CompanyInfo companyInfo, String pinyin) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError() || StringUtils.isBlank(companyHelper.getDatabaseName())) {
            return Collections.emptyList();
        }


        return null;
    }

    @Override
    public Staff getLastStaffBypinyin(CompanyInfo companyInfo, String pinyin) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError() || StringUtils.isBlank(companyHelper.getDatabaseName())) {
            return null;
        }


        return null;
    }

    @Override
    public AthenaResponse updateStaffById(CompanyInfo companyInfo, Staff staff) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError() || StringUtils.isBlank(companyHelper.getDatabaseName())) {
            return companyHelper.getResponse();
        }


        return null;
    }

}
