namespace java com.aries.department.athena.contract.thrift.service

include "dto.thrift"

//部门服务
service DepartmentService {

   //用于检测client-server之间通讯是否正常
   string ping(),

   dto.AthenaResponse addDepartment(1:dto.CompanyInfo companyInfo, 2:dto.DepartmentInfo departmentInfo),

   dto.DepartmentInfo getDepartmentById(1:dto.CompanyInfo companyInfo, 2:i64 departmentId),

   list<dto.DepartmentInfo> getRootDepartments(1:dto.CompanyInfo companyInfo),

   list<dto.DepartmentInfo> getSubDepartments(1:dto.CompanyInfo companyInfo, 2:i64 subDepartmentId),

   list<dto.DepartmentInfo> getAllDepartments(1:dto.CompanyInfo companyInfo),

   dto.AthenaResponse updateDepartmentNameById(1:dto.CompanyInfo companyInfo, 2:i64 departmentId, 3:string newDepartmentName),

   dto.AthenaResponse updateDepartmentLeaderById(1:dto.CompanyInfo companyInfo, 2:i64 departmentId, 3:i64 leaderId),

   dto.AthenaResponse updateSupDepartmentById(1:dto.CompanyInfo companyInfo, 2:i64 departmentId, 3:i64 supDepartmentId),

   dto.AthenaResponse deleteDepartmentById(1:dto.CompanyInfo companyInfo, 2:i64 departmentId),
//   list<dto.DepartmentInfo> getUnderDepartments(1:dto.CompanyInfo companyInfo, 2:i64 departmentId),
}

service StaffService {

   //用于检测client-server之间通讯是否正常
   string ping(),

   dto.AthenaResponse addStaff(1:dto.CompanyInfo companyInfo, 2:dto.StaffInfo staffInfo),

   dto.StaffInfo addAndGetStaff(1:dto.CompanyInfo companyInfo, 2:dto.StaffInfo staffInfo),

   dto.StaffInfo getStaffById(1:dto.CompanyInfo companyInfo, 2:i64 id),

   list<dto.StaffInfo> getStaffByName(1:dto.CompanyInfo companyInfo, 2:string name),

   list<dto.StaffInfo> getStaffByPinyin(1:dto.CompanyInfo companyInfo, 2:string pinyin),

   dto.StaffInfo getLastStaffBypinyin(1:dto.CompanyInfo companyInfo, 2:string pinyin),

   dto.AthenaResponse updateStaffById(1:dto.CompanyInfo companyInfo, 2:i64 id, 3:dto.StaffInfo staffInfo),

   list<dto.StaffInfo> getStaffByDepartmentId(1:dto.CompanyInfo companyInfo, 2:i64 departmentId, 3:i32 pageNum, 4:i32 pageSize),

   i64 getStaffCountByDepartmentId(1:dto.CompanyInfo companyInfo, 2:i64 departmentId),
}

service DailySignService {

   //用于检测client-server之间通讯是否正常
   string ping(),

   bool addSignNow(1:dto.CompanyInfo companyInfo, 2:i64 staffId),

   bool hasSigned(1:dto.CompanyInfo companyInfo, 2:i64 staffId, 3:i64 startTimeMills, 4:i64 endTimeMills),

   bool signNowIfNotSignedInPeriod(1:dto.CompanyInfo companyInfo, 2:i64 staffId, 3:i64 startTimeMills, 4:i64 endTimeMills),

   list<i64> getSignList(1:dto.CompanyInfo companyInfo, 2:i64 staffId, 3:i64 startTimeMills, 4:i64 endTimeMills),
}