package com.bw.movie.model.bean;

import java.util.List;

/**
 * date:2019/12/4
 * author:金豪(Lenovo)
 * function:
 */
public class MoviePingLunBean {

    /**
     * result : [{"commentTime":1575444805000,"director":"林德禄","imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","movieId":17,"movieName":"反贪风暴3","movieScore":0,"myCommentContent":"阿萨德","myCommentScore":14,"starring":"古天乐,张智霖,郑嘉颖,邓丽欣,谢天华"},{"commentTime":1574941417000,"director":"陈凯歌","imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg","movieId":23,"movieName":"我和我的祖国","movieScore":0,"myCommentContent":"我的祖国","myCommentScore":9,"starring":"黄渤,张译,杜江,葛优,刘昊然,吴京"},{"commentTime":1574919219000,"director":"\r\n李仁港","imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieId":25,"movieName":"攀登者","movieScore":0,"myCommentContent":"123","myCommentScore":9,"starring":"吴京,章子怡,井柏然,胡歌"},{"commentTime":1574912449000,"director":"曾国祥","imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieId":22,"movieName":"少年的你","movieScore":0,"myCommentContent":"电影好看","myCommentScore":4.5,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"},{"commentTime":1571637960000,"director":"托尼·班克罗夫特","imageUrl":"http://172.17.8.100/images/movie/stills/sqmxtzdwbg/sqmxtzdwbg1.jpg","movieId":6,"movieName":"神奇马戏团之动物饼干","movieScore":0,"myCommentContent":"电影好看","myCommentScore":4.5,"starring":"艾米莉·布朗特,约翰·卡拉辛斯基,西尔维斯特·史泰龙"}]
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
         * commentTime : 1575444805000
         * director : 林德禄
         * imageUrl : http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg
         * movieId : 17
         * movieName : 反贪风暴3
         * movieScore : 0
         * myCommentContent : 阿萨德
         * myCommentScore : 14
         * starring : 古天乐,张智霖,郑嘉颖,邓丽欣,谢天华
         */

        private long commentTime;
        private String director;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int movieScore;
        private String myCommentContent;
        private float myCommentScore;
        private String starring;

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

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

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getMovieScore() {
            return movieScore;
        }

        public void setMovieScore(int movieScore) {
            this.movieScore = movieScore;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }

        public float getMyCommentScore() {
            return myCommentScore;
        }

        public void setMyCommentScore(int myCommentScore) {
            this.myCommentScore = myCommentScore;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
