package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.dto.AthenaResponse;
import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.dto.StaffInfo;
import com.aries.department.athena.contract.thrift.service.StaffService;
import com.aries.department.athena.dal.po.Staff;
import com.aries.department.athena.dal.repository.StaffRepository;
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
public class StaffServiceImpl implements StaffService.Iface {
    @Override
    public String ping() throws TException {
        log.debug("Staff pong- -.");
        return "i am staff service";
    }

    @Override
    public AthenaResponse addStaff(CompanyInfo companyInfo, StaffInfo staffInfo) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        Staff staff = conver2Staff(staffInfo);
        try {
            int resp = StaffRepository.addStaff(companyHelper.getDatabaseName(), staff);

            if (resp == StaffRepository.State.NEED_RECALL.code()) {
                return RECALL.of();
            } else if (resp == StaffRepository.State.SUCCESS.code()) {
                return SUCCESS.of();
            } else {
                return ERROR.of();
            }
        } catch (Exception e) {
            return ERROR.of();
        }
    }

    @Override
    public StaffInfo getStaffById(CompanyInfo companyInfo, int id) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return null;
        }


        return null;
    }

    @Override
    public List<StaffInfo> getStaffByName(CompanyInfo companyInfo, String name) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }


        return null;
    }

    @Override
    public List<StaffInfo> getStaffByPinyin(CompanyInfo companyInfo, String pinyin) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }


        return null;
    }

    @Override
    public StaffInfo getLastStaffBypinyin(CompanyInfo companyInfo, String pinyin) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return null;
        }


        return null;
    }

    @Override
    public AthenaResponse updateStaffById(CompanyInfo companyInfo, long id, StaffInfo staffInfo) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return companyHelper.getResponse();
        }

        Staff staff = conver2Staff(staffInfo);
        try {
            boolean effect = StaffRepository.updateStaffById(companyHelper.getDatabaseName(), id, staff);
            return effect ? SUCCESS.of() : ERROR.of();
        } catch (Exception e) {
            return ERROR.of();
        }
    }

    @Override
    public List<StaffInfo> getStaffByDepartmentId(CompanyInfo companyInfo, long departmentId, int pageNum, int pageSize) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return Collections.emptyList();
        }
        List<Staff> staffList = StaffRepository.batchGetStaffByDepartmentId(companyHelper.getDatabaseName(), departmentId, pageNum, pageSize);
        return conver2StaffInfo(staffList);
    }

    @Override
    public long getStaffCountByDepartmentId(CompanyInfo companyInfo, long departmentId) throws TException {
        CompanyHelper companyHelper = new CompanyHelper(companyInfo).invoke();
        if (companyHelper.isError()) {
            return 0L;
        }
        return StaffRepository.getStaffCountByDepartmentId(companyHelper.getDatabaseName(), departmentId);
    }


    private static Staff conver2Staff(StaffInfo staffInfo) {
        Staff staff = new Staff();
//        staff.setId(staffInfo.getId());
        staff.setFullname(staffInfo.getFullname());
        staff.setAliasName(staffInfo.getAliasName());
        staff.setSex(staffInfo.getSex());
        staff.setEmail(staffInfo.getEmail());
        staff.setPhone(staffInfo.getPhone());
        staff.setQq(staffInfo.getQq());
        staff.setWechat(staffInfo.getWechat());
        staff.setJobLevel(staffInfo.getJobLevel());
        staff.setJobGroup(staffInfo.getJobGroup());
        staff.setDepartmentId(staffInfo.getDepartmentId());
        staff.setCountryId(staffInfo.getCountryId());
        staff.setCityId(staffInfo.getCityId());
        staff.setGaeaAccount(staffInfo.getGaeaAccount());
        staff.setEmployeeId(staffInfo.getEmployeeId());
        staff.setIdentityId(staffInfo.getIdentityId());
        staff.setAddress(staffInfo.getAddress());
        return staff;
    }

    private static StaffInfo conver2StaffInfo(Staff staff) {
        StaffInfo staffInfo = new StaffInfo();

        staffInfo.setId(staff.getId());
        staffInfo.setFullname(staff.getFullname());
        staffInfo.setAliasName(staff.getAliasName());
        staffInfo.setSex(Optional.ofNullable(staff.getSex()).orElse(Short.valueOf("0")));
        staffInfo.setEmail(staff.getEmail());
        staffInfo.setPhone(staff.getPhone());
        staffInfo.setQq(staff.getQq());
        staffInfo.setWechat(staff.getWechat());
        staffInfo.setJobLevel(staff.getJobLevel());
        staffInfo.setJobGroup(Optional.ofNullable(staff.getJobGroup()).orElse(0));
        staffInfo.setDepartmentId(Optional.ofNullable(staff.getDepartmentId()).orElse(0));
        staffInfo.setCountryId(Optional.ofNullable(staff.getCountryId()).orElse(Short.valueOf("0")));
        staffInfo.setCityId(Optional.ofNullable(staff.getCityId()).orElse(0));
        staffInfo.setGaeaAccount(staff.getGaeaAccount());
        staffInfo.setEmployeeId(staff.getEmployeeId());
        staffInfo.setIdentityId(Optional.ofNullable(staff.getIdentityId()).orElse(0));
        staffInfo.setAddress(staff.getAddress());
        staffInfo.setOnJob(Optional.ofNullable(staff.getOnJob()).orElse(true));
        staffInfo.setJoinTime(staff.getJoinTime().toString());
        return staffInfo;
    }

    private static List<StaffInfo> conver2StaffInfo(List<Staff> staffList) {
        if (CollectionUtils.isEmpty(staffList)) {
            return Collections.emptyList();
        }

        return staffList.stream()
                .map(StaffServiceImpl::conver2StaffInfo)
                .collect(Collectors.toList());
    }
}
