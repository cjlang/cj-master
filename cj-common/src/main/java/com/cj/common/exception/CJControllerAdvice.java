package com.cj.common.exception;

import com.cj.common.code.GlobalConst;
import com.cj.common.vo.J;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class CJControllerAdvice {

    /**
     * 系统运行的语法异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public J errorHandler(Exception ex) {
        return J.error(GlobalConst.Response_Sys_Err,ex.getMessage());
    }

    /**
     * 自定义的业务逻辑异常
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CJException.class)
    public J cjErrorHandler(CJException ex) {
        return J.error(ex.getCode(),ex.getMsg());
    }

}