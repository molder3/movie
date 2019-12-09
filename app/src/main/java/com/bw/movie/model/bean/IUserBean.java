package com.bw.movie.model.bean;

/**
 * date:2019/12/3
 * author:金豪(Lenovo)
 * function:
 */
public class IUserBean {

    /**
     * result : {"email":"3071069630@qq.com","headPic":"http://172.17.8.100/images/movie/head_pic/2019-12-03/20191203203341.unknown","id":13689,"lastLoginTime":1575376415000,"nickName":"婉珍","sex":1}
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
         * email : 3071069630@qq.com
         * headPic : http://172.17.8.100/images/movie/head_pic/2019-12-03/20191203203341.unknown
         * id : 13689
         * lastLoginTime : 1575376415000
         * nickName : 婉珍
         * sex : 1
         */

        private String email;
        private String headPic;
        private int id;
        private long lastLoginTime;
        private String nickName;
        private int sex;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(long lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }
    }
}
