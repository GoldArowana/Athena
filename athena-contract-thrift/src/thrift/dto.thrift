namespace java com.aries.department.athena.contract.thrift.dto

struct AthenaResponse{
    1: i32 code,
    2: string message="",
}

struct CompanyInfo {
    1: string name,
    2: string password,
    3: string keyword
}

struct PartnerInfo {
     1: i32 id,
     2: i32 companyId,
     3: string companyName,
     4: string password,
     5: string keyword,
     6: string insertTime,
     7: string updateTime
}

struct DepartmentInfo {
    1: i64 id,
    2: string departmentName,
    3: i64 leaderId,
    4: i64 upId
}

struct StaffInfo {
    1:  optional i64 id,
    2:  optional string fullname, //全名
    3:  optional string aliasName,//别名
    4:  optional i16 sex,//性别。0表示未设置。1表示男。2表示女。
    5:  optional string email,
    6:  optional string phone,
    7:  optional string qq,
    8:  optional string wechat,
    9:  optional string jobLevel,//职级
    10: optional i32 jobGroup,//职位类别。如"后台开发"
    11: optional bool onJob,//是否在职
    12: optional i32 departmentId,//所属部门id
    13: optional i16 countryId,//国家编码。
    14: optional i32 cityId,//城市id
    15: optional string gaeaAccount,//员工账号
    16: optional string employeeId,//员工号
    17: optional i32 identityId,//身份id。对应身份表里的身份信息。在中国指的是身份证相关信息。
    18: optional string address,//现住址
    19: optional string joinTime//入职时间
}
