package com.aries.department.athena.client.thrift;

import com.aries.department.athena.contract.thrift.service.StaffService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;

public class StaffServiceTest {
    @Test
    public void pingTest() throws TException {
        TTransport transport = new TSocket("localhost", 6001);
        TProtocol protocol = new TBinaryProtocol(transport);
        TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol, "StaffService");
        StaffService.Client client = new StaffService.Client(multiplexedProtocol);

        transport.open();
        String ping = client.ping2();
        System.out.println(ping);
        transport.close();
    }
}
