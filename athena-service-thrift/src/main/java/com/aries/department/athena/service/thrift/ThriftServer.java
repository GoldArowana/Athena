package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.service.DepartmentService;
import com.aries.department.athena.core.utils.PropertiesProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

@Slf4j
public class ThriftServer {

    private  DepartmentService.Iface service;

    private  DepartmentService.Processor processor;

    public  void start() {
        try {
            service = new DepartmentServiceImpl();
            processor = new DepartmentService.Processor(service);

            new Thread(() -> {
                try {
                    PropertiesProxy propertiesProxy = new PropertiesProxy("athena-service.properties");
                    int port = Integer.parseInt(propertiesProxy.readProperty("port"));

                    TServerTransport serverTransport = new TServerSocket(port);
                    TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
                    log.info("服务启动,端口:{}", port);
                    server.serve();

                } catch (Exception e) {
                    log.error("服务异常,error:{}", e.getMessage(), e);
                }
            }, "thrift-service-starter-thread").start();

        } catch (Exception x) {
            log.error("创建服务失败,error:{}", x.getMessage(), x);
        }
    }
}