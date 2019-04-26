package com.aries.department.athena.dal;

import com.aries.department.athena.dal.po.Staff;
import com.aries.department.athena.dal.repository.StaffRepository;
import org.junit.Test;

import java.util.List;

public class StaffRepositoryTest {
    @Test
    public void addStaffTest() {
        Staff staff = new Staff();
        staff.setFullname("小红");
        staff.setGaeaId("xiaohong01");
        staff.setSex(Short.valueOf("2"));
        StaffRepository.addStaff("athena_aries", staff);
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
}
