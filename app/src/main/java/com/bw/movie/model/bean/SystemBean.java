package com.bw.movie.model.bean;

import java.util.List;

/**
 * date:2019/12/6
 * author:金豪(Lenovo)
 * function:
 */
public class SystemBean {

    /**
     * result : [{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8570,"pushTime":1575340360000,"status":0,"title":"系统通知","userId":13689},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8190,"pushTime":1575081253000,"status":0,"title":"系统通知","userId":13689},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":7932,"pushTime":1575032951000,"status":0,"title":"系统通知","userId":13689},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":7928,"pushTime":1575032798000,"status":0,"title":"系统通知","userId":13689},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":6940,"pushTime":1574998270000,"status":0,"title":"系统通知","userId":13689}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 您已购买电影票,请尽快完成支付,以免影响到您的观影
         * id : 8570
         * pushTime : 1575340360000
         * status : 0
         * title : 系统通知
         * userId : 13689
         */

        private String content;
        private int id;
        private long pushTime;
        private int status;
        private String title;
        private int userId;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getPushTime() {
            return pushTime;
        }

        public void setPushTime(long pushTime) {
            this.pushTime = pushTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
