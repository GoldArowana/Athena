package com.aries.department.athena.dal;

import com.aries.department.athena.dal.po.Staff;
import com.aries.department.athena.dal.repository.StaffRepository;
import org.junit.Test;

public class StaffRepositoryTest {
    @Test
    public void addStaffTest() {
        Staff staff = new Staff();
        staff.setFullname("小红");
        staff.setSex(Short.valueOf("2"));
        StaffRepository.addStaff("athena_aries", staff);
    }
}
