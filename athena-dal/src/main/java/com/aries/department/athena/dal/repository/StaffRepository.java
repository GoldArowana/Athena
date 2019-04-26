package com.aries.department.athena.dal.repository;

import com.aries.department.athena.dal.mapper.StaffMapper;
import com.aries.department.athena.dal.po.Staff;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class StaffRepository {
    /**
     * @param database
     * @param staff
     * @return 0不成功，原因未知。1成功。2不成功,希望调用方重试。
     */

    public static int addStaff(String database, Staff staff) {
        if (staff == null) {
            return 0;
        }

        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            Example example = new Example(Staff.class);
            example.createCriteria().andEqualTo("fullname", staff.getFullname());
            example.orderBy("gaeaId").desc();
            Staff lastStaff = staffMapper.selectOneByExample(example);


            int effective = 0;
            try {
                effective = staffMapper.insertSelective(staff);
            } catch (PersistenceException e) {
                String template = "java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '%s' for key 'staff_gaea_id_uindex'";
                String.format(template, staff);
                System.out.println("error:" + e.getCause());
            }

            return effective;
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

    public static List<Staff> getStaffByName(String database, String name) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);

            // 构建查询条件
            Example example = new Example(Staff.class);
            example.createCriteria().andEqualTo("fullname", name);

            // 查询
            List<Staff> staff = staffMapper.selectByExample(example);

            return staff;
        }
    }

    public static Staff getLastStaffByName(String database, String name) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            StaffMapper staffMapper = session.getMapper(StaffMapper.class);
            Example example = new Example(Staff.class);
            example.createCriteria().andEqualTo("fullname", name);
            example.orderBy("gaeaId").desc();
            Staff staff = staffMapper.selectOneByExample(example);

            return staff;
        }
    }

    public static String getNextGaeaId(String database, String name) {
        String lastGaeaId = getLastStaffByName(database, name).getGaeaId();
        if (StringUtils.isBlank(name)) {
            return name + "01";
        }
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < lastGaeaId.length(); i++) {
            char at = lastGaeaId.charAt(i);
            if (at >= '0' && at <= '9') {
                numberBuilder.append(at);
            }
        }
        int nextId = Integer.valueOf(numberBuilder.toString()) + 1;
        if (nextId < 10) {
            return name + "0" + nextId;
        }
        return name + nextId;
    }
}
