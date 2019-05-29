package com.aries.department.athena.service.thrift;

import com.aries.department.athena.contract.thrift.service.DepartmentService;
import com.aries.department.athena.contract.thrift.service.StaffService;
import com.aries.department.athena.core.utils.PropertiesProxy;
import com.aries.hera.client.thrift.DiscoverClient;
import com.aries.hera.contract.thrift.dto.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import static com.aries.department.athena.core.constant.AppConst.APPNAME;
import static com.aries.department.athena.core.constant.AppConst.PORT;

@Slf4j
public class ThriftServer {

    public void start() {
        try {
            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            { // 准备注册 DepartmentService
                DepartmentService.Iface departmentService = new DepartmentServiceImpl();
                DepartmentService.Processor departmentProcessor = new DepartmentService.Processor<>(departmentService);
                String simpleName = DepartmentService.class.getSimpleName();
                processor.registerProcessor(simpleName, departmentProcessor);
            }

            { // 准备注册 StaffService
                StaffService.Iface staffService = new StaffServiceImpl();
                StaffService.Processor staffProcessor = new StaffService.Processor<>(staffService);
                String simpleName = StaffService.class.getSimpleName();
                processor.registerProcessor(simpleName, staffProcessor);
            }

            // 设置端口
            TServerTransport serverTransport = new TServerSocket(PORT);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            log.info("服务启动,端口:{}", PORT);

            // 用新线程开启服务。
            new Thread(() -> {
                try {
                    server.serve();
                } catch (Exception e) {
                    log.error("department服务异常,error:{}", e.getMessage(), e);
                }
            }, "thrift-service-starter-thread").start();


            // 注册服务
            PropertiesProxy heraProperties = new PropertiesProxy("/opt/config/local.properties");
            String apphost = heraProperties.readProperty("host");

            DiscoverClient.registe(new ServiceInfo(APPNAME, apphost, PORT));
            log.info("注册服务, appname:{}, host:{}, port:{}", APPNAME, apphost, PORT);
        } catch (Exception x) {
            log.error("创建服务失败,error:{}", x.getMessage(), x);
        }
    }
}