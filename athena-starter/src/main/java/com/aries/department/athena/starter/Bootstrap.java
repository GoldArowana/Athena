package com.aries.department.athena.starter;

import com.aries.department.athena.service.thrift.ThriftServer;

/**
 * Hello world!
 */
public class Bootstrap {
    public static void main(String[] args) {
        new ThriftServer().start();
    }
}
