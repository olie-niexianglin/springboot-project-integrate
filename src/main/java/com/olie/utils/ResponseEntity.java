package com.olie.utils;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {
    private static final long serialVersionUID = -6123494199269058433L;

    private int code = 0;
    private T data;
    private String msg = "";
    private String error = "";

    public static ResponseEntity ok = new ResponseEntity();
    public static ResponseEntity fail = new ResponseEntity().code(-1);

    public static ResponseEntity build() {
        return new ResponseEntity();
    }

    public static <T> ResponseEntity build(T data) {
        return new ResponseEntity().data(data);
    }

    public ResponseEntity code(int code) {
        this.code = code;
        return this;
    }

    public ResponseEntity data(T data) {
        this.data = data;
        return this;
    }

    public ResponseEntity msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseEntity error(String error) {
        this.error = error;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static ResponseEntity getOk() {
        return ok;
    }

    public static void setOk(ResponseEntity ok) {
        ResponseEntity.ok = ok;
    }

    public static ResponseEntity getFail() {
        return fail;
    }

    public static void setFail(ResponseEntity fail) {
        ResponseEntity.fail = fail;
    }
}
