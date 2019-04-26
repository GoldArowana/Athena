package com.aries.department.athena.client.thrift;

import com.aries.department.athena.contract.thrift.service.DepartmentService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;

public class DepartmentServiceTest {
    @Test
    public void pingTest() throws TException {
        TTransport transport = new TSocket("localhost", 6001);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        DepartmentService.Client client = new DepartmentService.Client(protocol);
        String ping = client.ping();
        System.out.println(ping);
        transport.close();
    }
}