package com.aries.department.athena.dal;

import com.aries.department.athena.dal.po.Staff;
import com.aries.department.athena.dal.repository.StaffRepository;
import org.junit.Test;

import java.util.List;

public class StaffRepositoryTest {
    @Test
    public void addStaffTest() {
        Staff staff = new Staff();
        staff.setFullname("金龙");
        staff.setSex(Short.valueOf("2"));
        System.out.println(StaffRepository.addStaff("athena_aries", staff));
    }

    @Test
    public void getStaffByIdTest() {
        Staff staff = StaffRepository.getStaffById("athena_aries", 3);
        System.out.println(staff);
    }

    @Test
    public void getStaffByNameTest() {
        List<Staff> staffByName = StaffRepository.getStaffByName("athena_aries", "小红");
        System.out.println(staffByName);
    }

    @Test
    public void getLastStaffBypinyinTest() {
        Staff staff = StaffRepository.getLastStaffBypinyin("athena_aries", "xiaohong");
        System.out.println(staff);
    }

}
