package com.aries.department.athena.client.thrift.facade;

import com.aries.department.athena.client.thrift.vo.StaffVO;
import com.aries.department.athena.contract.thrift.dto.AthenaResponse;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.dto.StaffInfo;
import com.aries.department.athena.contract.thrift.service.StaffService;
import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hera.core.utils.PropertiesProxy;
import org.apache.thrift.transport.TTransportException;

import java.util.List;

public class StaffFacade {
    private static final CompanyInfo companyInfo;

    static {
        PropertiesProxy propertiesProxy = new PropertiesProxy("athena-pass.properties");
        String company = propertiesProxy.readProperty("company");
        String password = propertiesProxy.readProperty("password");
        companyInfo = new CompanyInfo(company, password, "");
    }

    public static AthenaResponse addOne(StaffVO staffVO) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", StaffService.Client.class, client -> client.addStaff(companyInfo, StaffVO.toDTO(staffVO)));
    }

    public static List<StaffInfo> batchQeury(long departmentId, int pageNum, int pageSize) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", StaffService.Client.class, client -> client.getStaffByDepartmentId(companyInfo, departmentId, pageNum, pageSize));
    }

    public static Long getCountByDepartmentId(long departmentId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", StaffService.Client.class, client -> client.getStaffCountByDepartmentId(companyInfo, departmentId));
    }

    public static AthenaResponse updateSelectiveById(long id, StaffInfo staffInfo) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", StaffService.Client.class, client -> client.updateStaffById(companyInfo, id, staffInfo));
    }
}
