package com.bw.movie.model.bean;

/**
 * date:2019/12/4
 * author:金豪(Lenovo)
 * function:
 */
public class QRcodeBean {

    /**
     * result : {"exchangeCode":"http://172.17.8.100/images/movie/movieCode/20191129111832801.jpg","id":0,"recordId":0,"status":0}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
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

    public static class ResultBean {
        /**
         * exchangeCode : http://172.17.8.100/images/movie/movieCode/20191129111832801.jpg
         * id : 0
         * recordId : 0
         * status : 0
         */

        private String exchangeCode;
        private int id;
        private int recordId;
        private int status;

        public String getExchangeCode() {
            return exchangeCode;
        }

        public void setExchangeCode(String exchangeCode) {
            this.exchangeCode = exchangeCode;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
