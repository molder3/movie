package com.bw.movie.model.bean;

/**
 * date:2019/11/21
 * author:金豪(Lenovo)
 * function:
 */
public class WxBean {
    /**
     * result : {"sessionId":"157140055734413735","userId":13735,"userInfo":{"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/X5rIibvOT8wIhTQACS8cqYT77XzBibmdcooCW4Q3WJC3ILMw75yQv4wP3CkdbydoDibtTOf3LaNqHDdzw3iccNNIyQ/132","id":13735,"lastLoginTime":1571400557000,"nickName":"gfg_Xub","sex":1}}
     * message : 登陆成功
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
         * sessionId : 157140055734413735
         * userId : 13735
         * userInfo : {"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/X5rIibvOT8wIhTQACS8cqYT77XzBibmdcooCW4Q3WJC3ILMw75yQv4wP3CkdbydoDibtTOf3LaNqHDdzw3iccNNIyQ/132","id":13735,"lastLoginTime":1571400557000,"nickName":"gfg_Xub","sex":1}
         */

        private String sessionId;
        private int userId;
        private UserInfoBean userInfo;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public static class UserInfoBean {
            /**
             * headPic : http://thirdwx.qlogo.cn/mmopen/vi_32/X5rIibvOT8wIhTQACS8cqYT77XzBibmdcooCW4Q3WJC3ILMw75yQv4wP3CkdbydoDibtTOf3LaNqHDdzw3iccNNIyQ/132
             * id : 13735
             * lastLoginTime : 1571400557000
             * nickName : gfg_Xub
             * sex : 1
             */

            private String headPic;
            private int id;
            private long lastLoginTime;
            private String nickName;
            private int sex;

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
}
