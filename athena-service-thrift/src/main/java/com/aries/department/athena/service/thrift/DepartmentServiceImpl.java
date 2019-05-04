package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.dto.AthenaResponse;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.dto.DepartmentInfo;
import com.aries.department.athena.contract.thrift.service.DepartmentService;
import com.aries.department.athena.dal.po.Department;
import com.aries.department.athena.dal.repository.DepartmentRepository;
import com.aries.department.athena.service.thrift.util.CompanyHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.aries.department.athena.service.thrift.constant.AthenaResponseEnum.*;

@Slf4j
public class DepartmentServiceImpl implements DepartmentService.Iface {


    @Override
    public String ping() {
        log.debug("[pong- -.]");
        return "pong, i am department service";
    }

    @Override
    public AthenaResponse addDepartment(CompanyInfo companyInfo, DepartmentInfo departmentInfo) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        Department department = conver2Department(departmentInfo);

        try {
            boolean effect = DepartmentRepository.addDepartment(companyHelper.getDatabaseName(), department);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            return ERROR.of();
        }
    }

    @Override
    public DepartmentInfo getDepartmentById(CompanyInfo companyInfo, long departmentId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return null;
        }

        Department department = DepartmentRepository.getDepartmentById(companyHelper.getDatabaseName(), departmentId);

        return conver2DepartmentInfo(department);
    }

    @Override
    public List<DepartmentInfo> getRootDepartments(CompanyInfo companyInfo) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        List<Department> rootDepartments = DepartmentRepository.getRootDepartments(companyHelper.getDatabaseName());

        if (CollectionUtils.isNotEmpty(rootDepartments)) {
            return conver2DepartmentInfo(rootDepartments);
        }

        return Collections.emptyList();
    }

    @Override
    public List<DepartmentInfo> getSubDepartments(CompanyInfo companyInfo, long subDepartmentId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        List<Department> rootDepartments = DepartmentRepository.getSubDepartments(companyHelper.getDatabaseName(), subDepartmentId);

        if (CollectionUtils.isNotEmpty(rootDepartments)) {
            return conver2DepartmentInfo(rootDepartments);
        }

        return Collections.emptyList();
    }

    @Override
    public AthenaResponse updateDepartmentNameById(CompanyInfo companyInfo, long departmentId, String newDepartmentName) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        try {
            boolean effect = DepartmentRepository.updateDepartmentNameById(companyHelper.getDatabaseName(), departmentId, newDepartmentName);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            return ERROR.of();
        }
    }

    @Override
    public AthenaResponse updateDepartmentLeaderById(CompanyInfo companyInfo, long departmentId, long leaderId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        try {
            boolean effect = DepartmentRepository.updateDepartmentLeaderById(companyHelper.getDatabaseName(), departmentId, leaderId);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            return ERROR.of();
        }
    }

    @Override
    public AthenaResponse updateSupDepartmentById(CompanyInfo companyInfo, long departmentId, long supDepartmentId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        try {
            boolean effect = DepartmentRepository.updateSupDepartmentById(companyHelper.getDatabaseName(), departmentId, supDepartmentId);
            return effect ? SUCCESS.of() : NOT_CHANGED.of();
        } catch (Exception e) {
            return ERROR.of();
        }
    }

//    @Override
//    public List<DepartmentInfo> getUnderDepartments(CompanyInfo companyInfo, long departmentId) throws TException {
//        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
//        if (companyHelper.isError()) {
//            return Collections.emptyList();
//        }
//
//        List<Department> departmentList = DepartmentRepository.gets(companyHelper.getDatabaseName(), departmentId);
//        return conver2DepartmentInfo(departmentList);
//    }


    private static Department conver2Department(DepartmentInfo departmentInfo) {
        return new Department() {{
            setId(departmentInfo.getId());
            setUpId(departmentInfo.getUpId());
            setLeaderId(departmentInfo.getLeaderId());
            setDepartmentName(departmentInfo.getDepartmentName());
        }};
    }

    private static DepartmentInfo conver2DepartmentInfo(Department department) {
        return new DepartmentInfo() {{
            setId(Optional.ofNullable(department.getId()).orElse(0L));
            setUpId(Optional.ofNullable(department.getUpId()).orElse(0L));
            setLeaderId(Optional.ofNullable(department.getLeaderId()).orElse(0L));
            setDepartmentName(department.getDepartmentName());
        }};
    }

    private static List<DepartmentInfo> conver2DepartmentInfo(List<Department> departments) {
        if (CollectionUtils.isEmpty(departments)) {
            return Collections.emptyList();
        }

        return departments.stream()
                .map(DepartmentServiceImpl::conver2DepartmentInfo)
                .collect(Collectors.toList());
    }
}
