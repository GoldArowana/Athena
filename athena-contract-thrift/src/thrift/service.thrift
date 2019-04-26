namespace java com.aries.department.athena.contract.thrift.service

include "dto.thrift"

//部门服务
service DepartmentService {

   //用于检测client-server之间通讯是否正常
   string ping(),

   list<dto.DepartmentInfo> getDepartmentById(1:dto.CompanyInfo companyInfo,2:i32 departmentId)
}