package com.aries.department.athena.dal.repository;

import com.aries.department.athena.dal.mapper.StaffMapper;
import com.aries.department.athena.dal.po.Staff;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class StaffRepository {
    public static boolean addStaff(String database, Staff staff) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            int effective = staffMapper.insertSelective(staff);

            return effective > 0;
        }
    }

    public static Staff getStaffById(String database, int id) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            Staff staff = staffMapper.selectByPrimaryKey(id);

            return staff;
        }
    }


}
