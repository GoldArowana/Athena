package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.dto.DepartmentInfo;
import com.aries.department.athena.contract.thrift.service.DepartmentService;
import org.apache.thrift.TException;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService.Iface {
    @Override
    public String ping() throws TException {
        return "pong, i am department service";
    }

    @Override
    public List<DepartmentInfo> getDepartmentById(CompanyInfo companyInfo, int departmentId) throws TException {
        return null;
    }
}
