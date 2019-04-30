package com.aries.department.athena.client.thrift;

import com.aries.hera.client.thrift.DiscoverClient;
import com.aries.hera.contract.thrift.dto.ServiceInfo;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        ServiceInfo athena = DiscoverClient.getFirstService("athena");
        System.out.println(athena.getName());
        System.out.println(athena.getHost());
        System.out.println(athena.getPort());
    }

}
