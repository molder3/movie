package com.bw.movie.model.bean;

/**
 * date:2019/11/21
 * author:金豪(Lenovo)
 * function:
 */
public class TicketsBean {

    /**
     * orderId : 20180807084055347
     * message : 下单成功
     * status : 0000
     */

    private String orderId;
    private String message;
    private String status;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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
