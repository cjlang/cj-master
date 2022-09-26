package com.cj.common.vo;

import com.cj.common.code.GlobalConst;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ApiModel
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class J<T> implements Serializable {

    @ApiModelProperty(notes = "200成功，-1失败")
    private int code;

    @ApiModelProperty(notes = "描述")
    private String msg;

    @ApiModelProperty(notes = "结果")
    private T data;

    @ApiModelProperty(notes = "状态")
    private boolean state;

    public J(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> J<E> ok(E data) {
        return new J<E>(GlobalConst.Response_Suc, "OK", data);
    }

    public static <E> J<E> ok() {
        return new J<E>(GlobalConst.Response_Suc, "OK", null);
    }

    public static <E> J<E> getJBy(boolean isok){
        if(isok){
            return new J<E>(GlobalConst.Response_Suc, "OK", null);
        }else
        {
            return new J<E>(GlobalConst.Response_Err, "异常", null);
        }
    }

    public static J error(String msg) {
        J result = new J();
        result.setCode(GlobalConst.Response_Err);
        result.setMsg(msg);
        return result;
    }

    public static J error(int code, String msg) {
        J result = new J();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static J error() {
        J result = new J();
        result.setCode(GlobalConst.Response_Err);
        result.setMsg("异常");
        return result;
    }

    public J<T> put(T data) {
        this.data = data;
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == GlobalConst.Response_Suc;
    }

    @JsonIgnore
    public boolean isError() {
        return this.code != GlobalConst.Response_Suc;
    }
}

