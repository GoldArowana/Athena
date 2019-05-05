package com.aries.department.athena.client.thrift;

import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.service.StaffService;
import com.aries.hera.client.thrift.ThriftHelper;
import org.apache.thrift.TException;
import org.junit.Test;

public class StaffServiceTest {
    @Test
    public void pingTest() throws Exception {
//        List<StaffInfo> staffInfoList = StaffFacade.batchQeury(0, 1, 20);
//        System.out.println(staffInfoList);

        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setName("aries");
        companyInfo.setPassword("123456");
        Long count = ThriftHelper.call(StaffService.Client.class, client -> {
            try {
                return client.getStaffCountByDepartmentId(companyInfo, 0L);
            } catch (TException e) {
                e.printStackTrace();
                return 100L;
            }
        }, "localhost", 6001);

        System.out.println(count);
    }

}
