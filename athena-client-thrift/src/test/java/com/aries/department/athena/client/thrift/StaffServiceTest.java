package com.aries.department.athena.client.thrift;

import com.aries.department.athena.contract.thrift.dto.CompanyInfo;
import com.aries.department.athena.contract.thrift.service.StaffService;
import com.aries.hera.client.thrift.ThriftHelper;
import org.apache.thrift.TException;
import org.junit.Test;

import java.util.Collections;

public class StaffServiceTest {
    @Test
    public void pingTest() throws Exception {
//        List<StaffInfo> staffInfoList = StaffFacade.batchQeury(0, 1, 20);
//        System.out.println(staffInfoList);

        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setName("aries");
        companyInfo.setPassword("123456");
        ThriftHelper.call(StaffService.Client.class, client -> {
            try {
                return client.getStaffByDepartmentId(companyInfo, 0L, 1, 20);
            } catch (TException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        }, "localhost", 6001);


//        List<StaffInfo> staffInfoList = ThriftHelper.call("Athena", StaffService.Client.class, client -> client.getStaffByDepartmentId(companyInfo, 0L, 1, 20));
//        System.out.println(staffInfoList);
    }

}
