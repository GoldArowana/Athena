package com.aries.department.athena.service.thrift.constant;

import com.aries.department.athena.contract.thrift.dto.AthenaResponse;

public enum AthenaResponseEnum {
    NO_PERMISSION(1001, "没有访问权限"),
    SUCCESS(3000, "success"),
    NOT_CHANGED(3001, "no changed"),
    ERROR(4000, "系统错误"),
    RECALL(5000, "希望重新调用本方法");
    private int code;
    private String message;

    AthenaResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AthenaResponse of() {
        return new AthenaResponse(code, message);
    }
}
