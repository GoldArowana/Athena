namespace java com.aries.department.athena.contract.thrift.service

include "dto.thrift"

//部门服务
service DepartmentService {

   //用于检测client-server之间通讯是否正常
   string ping(),

   dto.AthenaResponse addDepartment(1:dto.CompanyInfo companyInfo, 2:dto.DepartmentInfo departmentInfo),

   list<dto.DepartmentInfo> getDepartmentById(1:dto.CompanyInfo companyInfo, 2:i32 departmentId),

   list<dto.DepartmentInfo> getRootDepartments(1:dto.CompanyInfo companyInfo),

   list<dto.DepartmentInfo> getSubDepartments(1:dto.CompanyInfo companyInfo, 2:i32 supDepartmentId),

   dto.AthenaResponse updateDepartmentNameById(1:dto.CompanyInfo companyInfo, 2:i32 departmentId, 3:string newDepartmentName),

   dto.AthenaResponse updateDepartmentLeaderById(1:dto.CompanyInfo companyInfo, 2:i32 departmentId, 3:i32 leaderId),

   dto.AthenaResponse updateSupDepartmentById(1:dto.CompanyInfo companyInfo, 2:i32 departmentId, 3:i32 supDepartmentId)
}

service StaffService {

   //用于检测client-server之间通讯是否正常
   string ping(),
   string ping2()
}