package com.aries.department.athena.client.thrift.facade;

import com.aries.department.athena.client.thrift.vo.DepartmentVO;
import com.aries.department.athena.contract.thrift.dto.AthenaResponse;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.dto.DepartmentInfo;
import com.aries.department.athena.contract.thrift.service.DepartmentService;
import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hera.core.utils.PropertiesProxy;
import org.apache.thrift.transport.TTransportException;

import java.util.List;

public class DepartmentFacade {
    private static final CompanyInfo companyInfo;

    static {
        PropertiesProxy propertiesProxy = new PropertiesProxy("athena-pass.properties");
        String company = propertiesProxy.readProperty("company");
        String password = propertiesProxy.readProperty("password");
        companyInfo = new CompanyInfo(company, password, "");
    }

    public static AthenaResponse addDepartment(DepartmentVO departmentVO) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", DepartmentService.Client.class, client -> client.addDepartment(companyInfo, DepartmentVO.toDTO(departmentVO)));
    }

    public static List<DepartmentInfo> getRootDepartments() throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", DepartmentService.Client.class, client -> client.getRootDepartments(companyInfo));
    }

    public static List<DepartmentInfo> getSubDepartments(long subDepartmentId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", DepartmentService.Client.class, client -> client.getSubDepartments(companyInfo, subDepartmentId));
    }

    public static List<DepartmentInfo> getAllDepartments() throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", DepartmentService.Client.class, client -> client.getAllDepartments(companyInfo));
    }

    public static AthenaResponse updateDepartmentNameById(long departmentId, String newDepartmentName) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", DepartmentService.Client.class, client -> client.updateDepartmentNameById(companyInfo, departmentId, newDepartmentName));
    }

    public static AthenaResponse updateSupDepartmentById(long departmentId, long supDepartmentId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", DepartmentService.Client.class, client -> client.updateSupDepartmentById(companyInfo, departmentId, supDepartmentId));
    }

    public static AthenaResponse deleteDepartmentById(long departmentId) throws ServiceNotFoundException, TTransportException {
        return ThriftHelper.call("Athena", DepartmentService.Client.class, client -> client.deleteDepartmentById(companyInfo, departmentId));
    }
}
