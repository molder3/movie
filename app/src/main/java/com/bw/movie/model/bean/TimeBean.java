package com.bw.movie.model.bean;

import java.util.List;

/**
 * date:2019/11/20
 * author:金豪(Lenovo)
 * function:
 */
public class TimeBean {

    /**
     * result : ["11-20","11-21","11-22","11-23","11-24","11-25","11-26"]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<String> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
