package com.bw.movie.model.bean;

import java.util.List;

/**
 * date:2019/12/2
 * author:金豪(Lenovo)
 * function:
 */
public class ReserveBean {

    /**
     * result : [{"imageUrl":"http://172.17.8.100/images/movie/stills/wbsys/wbsys1.jpg","movieId":1,"name":"我不是药神","releaseTime":1530720000000,"wantSeeNum":16}]
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
         * imageUrl : http://172.17.8.100/images/movie/stills/wbsys/wbsys1.jpg
         * movieId : 1
         * name : 我不是药神
         * releaseTime : 1530720000000
         * wantSeeNum : 16
         */

        private String imageUrl;
        private int movieId;
        private String name;
        private long releaseTime;
        private int wantSeeNum;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getWantSeeNum() {
            return wantSeeNum;
        }

        public void setWantSeeNum(int wantSeeNum) {
            this.wantSeeNum = wantSeeNum;
        }
    }
}
