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

        Department department = convert2Department(departmentInfo);

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

        return convert2DepartmentInfo(department);
    }

    @Override
    public List<DepartmentInfo> getRootDepartments(CompanyInfo companyInfo) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        List<Department> rootDepartments = DepartmentRepository.getRootDepartments(companyHelper.getDatabaseName());

        if (CollectionUtils.isNotEmpty(rootDepartments)) {
            return convert2DepartmentInfo(rootDepartments);
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
            return convert2DepartmentInfo(rootDepartments);
        }

        return Collections.emptyList();
    }

    @Override
    public List<DepartmentInfo> getAllDepartments(CompanyInfo companyInfo) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }

        List<Department> rootDepartments = DepartmentRepository.getAllDepartments(companyHelper.getDatabaseName());

        if (CollectionUtils.isNotEmpty(rootDepartments)) {
            return convert2DepartmentInfo(rootDepartments);
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

    @Override
    public AthenaResponse deleteDepartmentById(CompanyInfo companyInfo, long departmentId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        try {
            boolean effect = DepartmentRepository.deleteDepartmentById(companyHelper.getDatabaseName(), departmentId);
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
//        return convert2DepartmentInfo(departmentList);
//    }


    private static Department convert2Department(DepartmentInfo departmentInfo) {
        Department department = new Department();
        if (departmentInfo.isSetId()) {
            department.setId(departmentInfo.getId());
        }
        if (departmentInfo.isSetUpId()) {
            department.setUpId(departmentInfo.getUpId());
        }
        if (departmentInfo.isSetLeaderId()) {
            department.setLeaderId(departmentInfo.getLeaderId());
        }
        if (departmentInfo.isSetDepartmentName()) {
            department.setDepartmentName(departmentInfo.getDepartmentName());
        }
        return department;
    }

    private static DepartmentInfo convert2DepartmentInfo(Department department) {
        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.setId(Optional.ofNullable(department.getId()).orElse(0L));
        departmentInfo.setUpId(Optional.ofNullable(department.getUpId()).orElse(0L));
        departmentInfo.setLeaderId(Optional.ofNullable(department.getLeaderId()).orElse(0L));
        departmentInfo.setDepartmentName(department.getDepartmentName());
        return departmentInfo;
    }

    private static List<DepartmentInfo> convert2DepartmentInfo(List<Department> departments) {
        if (CollectionUtils.isEmpty(departments)) {
            return Collections.emptyList();
        }

        return departments.stream()
                .map(DepartmentServiceImpl::convert2DepartmentInfo)
                .collect(Collectors.toList());
    }
}
