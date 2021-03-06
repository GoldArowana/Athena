package com.aries.department.athena.dal.repository;

import com.aries.department.athena.dal.mapper.DepartmentMapper;
import com.aries.department.athena.dal.po.Department;
import com.aries.department.athena.dal.util.SqlSessionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

public class DepartmentRepository {
    /**
     * 添加部门
     *
     * @param database   数据库
     * @param department 部门信息
     * @return
     */
    public static boolean addDepartment(String database, Department department) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DepartmentMapper department1 = session.getMapper(DepartmentMapper.class);

            int effective = department1.insertSelective(department);

            return effective > 0;
        }
    }

    /**
     * 根据id获取部门信息
     *
     * @param database     数据库
     * @param departmentId 主部门
     * @return 主部门对应的所有子部门
     */
    public static Department getDepartmentById(String database, Long departmentId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);

            // 构建example
            Example example = new Example(Department.class);
            example.createCriteria().andEqualTo("id", departmentId);

            Department department = departmentMapper.selectOneByExample(example);

            return department;
        }
    }

    /**
     * 获取所有主部门
     *
     * @param database 数据库名
     * @return
     */
    public static List<Department> getRootDepartments(String database) {
        return getSubDepartments(database, 0L);
    }

    public static List<Department> getSubDepartments(String database, Department department) {
        if (department == null) {
            return Collections.emptyList();
        }
        return getSubDepartments(database, department.getId());
    }

    /**
     * 查找主id为supDepartmentId的，所有子部门
     *
     * @param database        数据库
     * @param supDepartmentId 主部门
     * @return 主部门对应的所有子部门
     */
    public static List<Department> getSubDepartments(String database, Long supDepartmentId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);

            // 构建example
            Example example = new Example(Department.class);
            example.createCriteria().andEqualTo("upId", supDepartmentId);

            List<Department> departments = departmentMapper.selectByExample(example);

            if (CollectionUtils.isNotEmpty(departments)) {
                return departments;
            }
        }
        return Collections.emptyList();
    }

    public static List<Department> getAllDepartments(String databaseName) {
        try (SqlSession session = SqlSessionUtil.openSession(databaseName)) {
            // 获取Mapper
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);

            List<Department> departments = departmentMapper.selectAll();

            if (CollectionUtils.isNotEmpty(departments)) {
                return departments;
            }
        }
        return Collections.emptyList();
    }

    /**
     * 根据部门id修改部门名
     *
     * @param database          数据库名
     * @param departmentId      部门id
     * @param newDepartmentName 部门名
     * @return
     */
    public static boolean updateDepartmentNameById(String database, Long departmentId, String newDepartmentName) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);

            Department department = new Department();
            department.setId(departmentId);
            department.setDepartmentName(newDepartmentName);

            return departmentMapper.updateByPrimaryKeySelective(department) > 0;
        }
    }

    /**
     * 根据部门id对应的部长id
     *
     * @param database     数据库名
     * @param departmentId 部门id
     * @param leaderId     部长id
     * @return
     */
    public static boolean updateDepartmentLeaderById(String database, Long departmentId, Long leaderId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);

            Department department = new Department();
            department.setId(departmentId);
            department.setLeaderId(leaderId);

            return departmentMapper.updateByPrimaryKeySelective(department) > 0;
        }
    }

    /**
     * 根据部门id，修改上级部门id。
     *
     * @param database        数据库名
     * @param departmentId    部门id
     * @param supDepartmentId 上级部门id
     * @return
     */
    public static boolean updateSupDepartmentById(String database, Long departmentId, Long supDepartmentId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            // 获取Mapper
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);

            Department department = new Department();
            department.setId(departmentId);
            department.setUpId(supDepartmentId);

            return departmentMapper.updateByPrimaryKeySelective(department) > 0;
        }
    }


    public static boolean deleteDepartmentById(String database, Long departmentId) {
        try (SqlSession session = SqlSessionUtil.openSession(database)) {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            return departmentMapper.deleteByPrimaryKey(departmentId) > 0;
        }
    }

//    public static List<Long> getUnderDepartmentIds(String database, Long departmentId) {
//        List<Department> departmentList = getUnderDepartments(database, departmentId);
//        if (CollectionUtils.isEmpty(departmentList)) {
//            return Collections.emptyList();
//        }
//        return departmentList.stream().map(Department::getId).collect(Collectors.toList());
//    }
//
//    public static List<Department> getUnderDepartments(String database, Long departmentId) {
//        try (SqlSession session = SqlSessionUtil.openSession(database)) {
//            // 获取Mapper
//            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
//
//            Example example = new Example(Department.class);
//            example.createCriteria().andEqualTo("upId", departmentId);
//            List<Department> departmentList = departmentMapper.selectByExample(example);
//            return CollectionUtils.isEmpty(departmentList) ? Collections.emptyList() : departmentList;
//        }
//    }
}
