package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.service.StaffService;
import org.apache.thrift.TException;

public class StaffServiceImpl implements StaffService.Iface {
    @Override
    public String ping() throws TException {
        return "i am staff service";
    }

    @Override
    public String ping2() throws TException {
        return "i am staff service2";
    }
}
