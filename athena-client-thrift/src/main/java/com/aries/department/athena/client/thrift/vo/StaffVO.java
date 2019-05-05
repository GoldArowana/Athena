package com.aries.department.athena.client.thrift.vo;

import com.aries.department.athena.contract.thrift.dto.StaffInfo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StaffVO {
    private long id;
    private String fullname;
    private String aliasName;
    private short sex;
    private String email;
    private String phone;
    private String qq;
    private String wechat;
    private String jobLevel;
    private int jobGroup;
    private boolean onJob;
    private int departmentId;
    private short countryId;
    private int cityId;
    private String gaeaAccount;
    private String employeeId;
    private int identityId;
    private String address;
    private String joinTime;

    public long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAliasName() {
        return aliasName;
    }

    public short getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getQq() {
        return qq;
    }

    public String getWechat() {
        return wechat;
    }

    public String getJobLevel() {
        return jobLevel;
    }

    public int getJobGroup() {
        return jobGroup;
    }

    public boolean isOnJob() {
        return onJob;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public short getCountryId() {
        return countryId;
    }

    public int getCityId() {
        return cityId;
    }

    public String getGaeaAccount() {
        return gaeaAccount;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getIdentityId() {
        return identityId;
    }

    public String getAddress() {
        return address;
    }

    public String getJoinTime() {
        return joinTime;
    }


    public static final class StaffVOBuilder {
        private String fullname;
        private String aliasName;
        private short sex;
        private String email;
        private String phone;
        private String qq;
        private String wechat;
        private String jobLevel;
        private int jobGroup;
        private boolean onJob;
        private int departmentId;
        private short countryId;
        private int cityId;
        private String employeeId;
        private int identityId;
        private String address;

        private StaffVOBuilder() {
        }

        public static StaffVOBuilder aStaffVO() {
            return new StaffVOBuilder();
        }

        public StaffVOBuilder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public StaffVOBuilder aliasName(String aliasName) {
            this.aliasName = aliasName;
            return this;
        }

        public StaffVOBuilder sex(short sex) {
            this.sex = sex;
            return this;
        }

        public StaffVOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StaffVOBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public StaffVOBuilder qq(String qq) {
            this.qq = qq;
            return this;
        }

        public StaffVOBuilder wechat(String wechat) {
            this.wechat = wechat;
            return this;
        }

        public StaffVOBuilder jobLevel(String jobLevel) {
            this.jobLevel = jobLevel;
            return this;
        }

        public StaffVOBuilder jobGroup(int jobGroup) {
            this.jobGroup = jobGroup;
            return this;
        }

        public StaffVOBuilder onJob(boolean onJob) {
            this.onJob = onJob;
            return this;
        }

        public StaffVOBuilder departmentId(int departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public StaffVOBuilder countryId(short countryId) {
            this.countryId = countryId;
            return this;
        }

        public StaffVOBuilder cityId(int cityId) {
            this.cityId = cityId;
            return this;
        }

        public StaffVOBuilder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public StaffVOBuilder identityId(int identityId) {
            this.identityId = identityId;
            return this;
        }

        public StaffVOBuilder address(String address) {
            this.address = address;
            return this;
        }

        public StaffVO build() {
            StaffVO staffVO = new StaffVO();
            staffVO.address = this.address;
            staffVO.wechat = this.wechat;
            staffVO.countryId = this.countryId;
            staffVO.cityId = this.cityId;
            staffVO.sex = this.sex;
            staffVO.employeeId = this.employeeId;
            staffVO.onJob = this.onJob;
            staffVO.fullname = this.fullname;
            staffVO.email = this.email;
            staffVO.jobLevel = this.jobLevel;
            staffVO.phone = this.phone;
            staffVO.jobGroup = this.jobGroup;
            staffVO.aliasName = this.aliasName;
            staffVO.departmentId = this.departmentId;
            staffVO.identityId = this.identityId;
            staffVO.qq = this.qq;
            return staffVO;
        }
    }

    public static StaffInfo toDTO(StaffVO staffVO) {
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setAddress(staffVO.address);
        staffInfo.setWechat(staffVO.wechat);
        staffInfo.setCountryId(staffVO.countryId);
        staffInfo.setCityId(staffVO.cityId);
        staffInfo.setSex(staffVO.sex);
        staffInfo.setEmployeeId(staffVO.employeeId);
        staffInfo.setOnJob(staffVO.onJob);
        staffInfo.setFullname(staffVO.fullname);
        staffInfo.setEmail(staffVO.email);
        staffInfo.setJobLevel(staffVO.jobLevel);
        staffInfo.setPhone(staffVO.phone);
        staffInfo.setJobGroup(staffVO.jobGroup);
        staffInfo.setAliasName(staffVO.aliasName);
        staffInfo.setDepartmentId(staffVO.departmentId);
        staffInfo.setIdentityId(staffVO.identityId);
        staffInfo.setQq(staffVO.qq);
        return staffInfo;
    }

    public static StaffVO buildFromDTO(StaffInfo staffInfo) {
        StaffVO staffVO = new StaffVO();
        staffVO.id = staffInfo.id;
        staffVO.fullname = staffInfo.fullname;
        staffVO.aliasName = staffInfo.aliasName;
        staffVO.sex = staffInfo.sex;
        staffVO.email = staffInfo.email;
        staffVO.phone = staffInfo.phone;
        staffVO.qq = staffInfo.qq;
        staffVO.wechat = staffInfo.wechat;
        staffVO.jobLevel = staffInfo.jobLevel;
        staffVO.jobGroup = staffInfo.jobGroup;
        staffVO.onJob = staffInfo.onJob;
        staffVO.departmentId = staffInfo.departmentId;
        staffVO.countryId = staffInfo.countryId;
        staffVO.cityId = staffInfo.cityId;
        staffVO.gaeaAccount = staffInfo.gaeaAccount;
        staffVO.employeeId = staffInfo.employeeId;
        staffVO.identityId = staffInfo.identityId;
        staffVO.address = staffInfo.address;
        staffVO.joinTime = staffInfo.joinTime;
        return staffVO;
    }

    public static List<StaffVO> buildFromDTO(List<StaffInfo> staffInfoList) {
        if (CollectionUtils.isEmpty(staffInfoList)) {
            return Collections.emptyList();
        }
        return staffInfoList.stream().map(StaffVO::buildFromDTO).collect(Collectors.toList());
    }
}
