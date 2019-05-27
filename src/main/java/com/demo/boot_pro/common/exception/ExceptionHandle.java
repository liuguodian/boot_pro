package com.demo.boot_pro.common.exception;

import com.demo.boot_pro.common.exception.errorcode.CommonErrorCode;
import com.demo.boot_pro.common.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

/**
 * 统一的异常处理类
 * Created by Administrator on 2018/11/23 0023.
 */
@ControllerAdvice
public class ExceptionHandle {




  /*  @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult handle(HttpServletRequest request, HttpServletResponse response,Exception e) {
        ResponseResult responseResult = new ResponseResult();
        BaseException baseException =new BaseException(CommonErrorCode.FAIL);
        responseResult.setErrCode(baseException.getCode());
        responseResult.setErrMsg(baseException.getMessage());
        responseResult.setSuccess(false);
        responseResult.setData(e.toString());
        return responseResult;
    }*/


   public static final String DEFAULT_ERROR_VIEW = "error";
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", "/error");
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }



}
