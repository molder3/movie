package com.bw.movie.model.bean;

/**
 * date:2019/12/3
 * author:金豪(Lenovo)
 * function:
 */
public class UploadingBean {


    /**
     * headPath : http://172.17.8.100/images/movie/head_pic/2019-12-03/20191203150602.unknown
     * message : 上传成功
     * status : 0000
     */

    private String headPath;
    private String message;
    private String status;

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
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
