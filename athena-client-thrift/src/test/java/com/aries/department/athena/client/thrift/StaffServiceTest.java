package com.aries.department.athena.client.thrift;

import com.aries.department.athena.contract.thrift.service.DepartmentService;
import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.client.thrift.exception.ServiceNotFoundException;
import com.aries.hera.client.thrift.function.Try;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;

public class StaffServiceTest {
    @Test
    public void pingTest() throws Exception {
//        TTransport transport = new TSocket(athena.getHost(), athena.getPort());
//        TProtocol protocol = new TBinaryProtocol(transport);
//        TMultiplexedProtocol multiplexedProtocol = new TMultiplexedProtocol(protocol, "StaffService");
//        StaffService.Client client = new StaffService.Client(multiplexedProtocol);
//
//        transport.open();
//        String ping = client.ping();
//        System.out.println(ping);
//        transport.close();

//        ServiceInfo athena = DiscoverClient.getFirstService("athena");
//        call((client) -> {
//            try {
//                client.ping();
//            } catch (TException e) {
//                e.printStackTrace();
//            }
//            return "";
//        });
//        System.out.println(athena);
        ThriftHelper.call("athena", DepartmentService.Client.class,client->client.ping());
    }

}
