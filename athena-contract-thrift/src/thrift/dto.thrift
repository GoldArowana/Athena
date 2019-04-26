namespace java com.aries.department.athena.contract.thrift.dto

struct CompanyInfo {
    1: string name,
    2: string password,
    3: i32 keyword
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
    1: i32 id,
    2: string departmentName,
    3: i32 leaderId, 
    4: i32 upId
}

struct Staff {
    1: i32 id,
    2: string fullname, //全名
    3: i32 aliasName,//别名
    4: i16 sex,//性别。0表示未设置。1表示男。2表示女。
    5: string email,
    6: string phone,
    7: string qq,
    8: string wechat,
    9: string jobLevel,//职级
    10: i32 jobGroup,//职位类别。如"后台开发"
    11: bool onJob,//是否在职
    12: i32 departmentId,//所属部门id
    13: i16 countryId,//国家编码。
    14: i32 cityId,//城市id
    15: string gaeaId,//员工账号
    16: string employeeId,//员工号
    17: i32 identityId,//身份id。对应身份表里的身份信息。在中国指的是身份证相关信息。
    18: string address,//现住址
    19: string joinTime//入职时间
}
