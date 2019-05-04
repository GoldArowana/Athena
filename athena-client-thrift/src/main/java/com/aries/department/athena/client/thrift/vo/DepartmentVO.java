package com.aries.department.athena.client.thrift.vo;

import com.aries.department.athena.contract.thrift.dto.DepartmentInfo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentVO {
    private long id;
    private String departmentName;
    private long leaderId;
    private long upId;

    public long getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public long getLeaderId() {
        return leaderId;
    }

    public long getUpId() {
        return upId;
    }


    public static final class DepartmentVOBuilder {
        private String departmentName;
        private long leaderId;
        private long upId;

        private DepartmentVOBuilder() {
        }

        public static DepartmentVOBuilder aDepartmentVO() {
            return new DepartmentVOBuilder();
        }

        public DepartmentVOBuilder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public DepartmentVOBuilder leaderId(long leaderId) {
            this.leaderId = leaderId;
            return this;
        }

        public DepartmentVOBuilder upId(long upId) {
            this.upId = upId;
            return this;
        }

        public DepartmentVO build() {
            DepartmentVO departmentVO = new DepartmentVO();
            departmentVO.departmentName = this.departmentName;
            departmentVO.upId = this.upId;
            departmentVO.leaderId = this.leaderId;
            return departmentVO;
        }
    }

    public static DepartmentInfo toDTO(DepartmentVO departmentVO) {
        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.departmentName = departmentVO.departmentName;
        departmentInfo.leaderId = departmentVO.leaderId;
        departmentInfo.upId = departmentVO.upId;
        return departmentInfo;
    }

    public static DepartmentVO buildFromDTO(DepartmentInfo departmentInfo) {
        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.id = departmentInfo.id;
        departmentVO.departmentName = departmentInfo.departmentName;
        departmentVO.leaderId = departmentInfo.leaderId;
        departmentVO.upId = departmentInfo.upId;
        return departmentVO;
    }

    public static List<DepartmentVO> buildFromDTO(List<DepartmentInfo> departmentInfoList) {
        if (CollectionUtils.isEmpty(departmentInfoList)) {
            return Collections.emptyList();
        }
        return departmentInfoList.stream().map(DepartmentVO::buildFromDTO).collect(Collectors.toList());
    }
}
