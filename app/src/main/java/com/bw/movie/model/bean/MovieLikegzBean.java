package com.bw.movie.model.bean;

import java.util.List;

/**
 * date:2019/12/1
 * author:金豪(Lenovo)
 * function:
 */
public class MovieLikegzBean {

    /**
     * result : [{"director":"曾国祥","imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieId":22,"name":"少年的你","score":9.5,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"}]
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
         * director : 曾国祥
         * imageUrl : http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg
         * movieId : 22
         * name : 少年的你
         * score : 9.5
         * starring : 周冬雨,易烊千玺,张耀,周也,尹昉
         */

        private String director;
        private String imageUrl;
        private int movieId;
        private String name;
        private double score;
        private String starring;

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

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

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
