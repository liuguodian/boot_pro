package com.demo.boot_pro.common.exception;

import com.demo.boot_pro.common.exception.errorcode.CommonErrorCode;
import com.demo.boot_pro.common.exception.errorcode.IErrorCode;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 主动抛异常时，应使用此异常类（自定义）
 * Created by Administrator on 2018/11/23 0023.
 */
public class BaseException extends RuntimeException {

    private Integer code;
    public BaseException(CommonErrorCode commonErrorCode) {
        super(commonErrorCode.errName());
        this.code = commonErrorCode.errCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
