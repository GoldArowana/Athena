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

import static com.aries.department.athena.core.constant.ServerNameConst.DEPARTMENT;
import static com.aries.department.athena.core.constant.ServerNameConst.STAFF;

@Slf4j
public class ThriftServer {

    public void start() {
        try {
            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            { // 准备注册 DepartmentService
                DepartmentService.Iface departmentService = new DepartmentServiceImpl();
                DepartmentService.Processor departmentProcessor = new DepartmentService.Processor(departmentService);
                processor.registerProcessor(DEPARTMENT, departmentProcessor);
            }

            { // 准备注册 StaffService
                StaffService.Iface staffService = new StaffServiceImpl();
                StaffService.Processor staffProcessor = new StaffService.Processor(staffService);
                processor.registerProcessor(STAFF, staffProcessor);
            }

            // 从配置文件获取端口 6001
            PropertiesProxy propertiesProxy = new PropertiesProxy("athena-service.properties");
            int port = Integer.parseInt(propertiesProxy.readProperty("port"));

            // 设置端口
            TServerTransport serverTransport = new TServerSocket(port);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            log.info("服务启动,端口:{}", port);

            // 用新线程开启服务。
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