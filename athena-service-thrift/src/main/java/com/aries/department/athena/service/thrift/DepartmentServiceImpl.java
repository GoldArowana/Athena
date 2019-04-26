package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.dto.AthenaResponse;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.dto.DepartmentInfo;
import com.aries.department.athena.contract.thrift.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

import java.util.List;

@Slf4j
public class DepartmentServiceImpl implements DepartmentService.Iface {
    @Override
    public String ping() {
        log.debug("[pong- -.]");
        return "pong, i am department service";
    }

    @Override
    public AthenaResponse addDepartment(CompanyInfo companyInfo, DepartmentInfo departmentInfo) throws TException {
        return null;
    }

    @Override
    public List<DepartmentInfo> getDepartmentById(CompanyInfo companyInfo, int departmentId) throws TException {
        return null;
    }

    @Override
    public List<DepartmentInfo> getRootDepartments(CompanyInfo companyInfo) throws TException {
        return null;
    }

    @Override
    public List<DepartmentInfo> getSubDepartments(CompanyInfo companyInfo, int supDepartmentId) throws TException {
        return null;
    }

    @Override
    public AthenaResponse updateDepartmentNameById(CompanyInfo companyInfo, int departmentId, String newDepartmentName) throws TException {
        return null;
    }

    @Override
    public AthenaResponse updateDepartmentLeaderById(CompanyInfo companyInfo, int departmentId, int leaderId) throws TException {
        return null;
    }

    @Override
    public AthenaResponse updateSupDepartmentById(CompanyInfo companyInfo, int departmentId, int supDepartmentId) throws TException {
        return null;
    }

}
