package com.bw.movie.model.bean;

/**
 * date:2019/12/1
 * author:金豪(Lenovo)
 * function:
 */
public class MovieNoLikeBean {

    /**
     * message : 取消关注成功
     * status : 0000
     */

    private String message;
    private String status;

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
}
