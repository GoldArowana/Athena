package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.service.DepartmentService;
import com.aries.department.athena.contract.thrift.service.StaffService;
import com.aries.department.athena.core.utils.PropertiesProxy;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

@Slf4j
public class ThriftServer {

    public void start() {
        try {
            DepartmentService.Iface departmentService = new DepartmentServiceImpl();
            DepartmentService.Processor departmentProcessor = new DepartmentService.Processor(departmentService);

            StaffService.Iface staffService = new StaffServiceImpl();
            StaffService.Processor staffProcessor = new StaffService.Processor(staffService);

            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            processor.registerProcessor("DepartmentService",departmentProcessor);
            processor.registerProcessor("StaffService",staffProcessor);

            PropertiesProxy propertiesProxy = new PropertiesProxy("athena-service.properties");
            int port = Integer.parseInt(propertiesProxy.readProperty("port"));

            TServerTransport serverTransport = new TServerSocket(port);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            log.info("服务启动,端口:{}", port);

            new Thread(() -> {
                try {
                    server.serve();
                } catch (Exception e) {
                    log.error("department服务异常,error:{}", e.getMessage(), e);
                }
            }, "thrift-service-starter-thread").start();

        } catch (Exception x) {
            log.error("创建服务失败,error:{}", x.getMessage(), x);
        }
    }
}