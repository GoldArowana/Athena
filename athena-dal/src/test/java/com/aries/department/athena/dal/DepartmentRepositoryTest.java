package com.aries.department.athena.dal;

import com.aries.department.athena.dal.po.Department;
import com.aries.department.athena.dal.repository.DepartmentRepository;
import org.junit.Test;

import java.util.List;

public class DepartmentRepositoryTest {
    @Test
    public void addDepartmentTest() {
        Department department = new Department();
        department.setDepartmentName("酒店后勤1组");
        department.setUpId(3);
//        DepartmentRepository.addDepartment("athena_aries",department);
    }

    @Test
    public void getDepartmentTest() {
        Department department = DepartmentRepository.getDepartmentById("athena_aries", 1);
        System.out.println(department);
    }

    @Test
    public void getRootDepartmentsTest() {
        List<Department> rootDepartments = DepartmentRepository.getRootDepartments("athena_aries");
        System.out.println(rootDepartments);
    }

    @Test
    public void getSubDepartmentsTest() {
        List<Department> departments = DepartmentRepository.getSubDepartments("athena_aries", 1);
        System.out.println(departments);
    }

    @Test
    public void updateDepartmentNameTest() {
        DepartmentRepository.updateDepartmentNameById("athena_aries", 4, "酒店后勤2组");
        Department department = DepartmentRepository.getDepartmentById("athena_aries", 4);
        System.out.println(department);
    }

    @Test
    public void updateDepartmentLeaderTest() {
        DepartmentRepository.updateDepartmentLeaderById("athena_aries", 4, 1);
        Department department = DepartmentRepository.getDepartmentById("athena_aries", 4);
        System.out.println(department);
    }

    @Test
    public void updateSupDepartmentTest() {
        DepartmentRepository.updateSupDepartmentById("athena_aries", 2, 0);
        Department department = DepartmentRepository.getDepartmentById("athena_aries", 2);
        System.out.println(department);
    }
}
