package com.bw.movie.model.bean;

import java.util.List;

/**
 * date:2019/12/3
 * author:金豪(Lenovo)
 * function:
 */
public class TickBean {

    /**
     * result : [{"amount":1,"createTime":1574939503000,"id":3942,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128191143240","price":0.01},{"amount":1,"createTime":1574940469000,"id":3943,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128192749580","price":0.01},{"amount":1,"createTime":1574942434000,"id":3944,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128200034750","price":0.01},{"amount":1,"createTime":1574942437000,"id":3945,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128200037933","price":0.01},{"amount":1,"createTime":1574942702000,"id":3946,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128200502113","price":0.01},{"amount":1,"createTime":1574942703000,"id":3947,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128200503504","price":0.01},{"amount":1,"createTime":1574942704000,"id":3948,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128200504710","price":0.01},{"amount":1,"createTime":1574942704000,"id":3949,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128200504908","price":0.01},{"amount":1,"createTime":1574942991000,"id":3952,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191128200951065","price":0.01},{"amount":1,"createTime":1574943030000,"id":3953,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191128201030694","price":0.01},{"amount":1,"createTime":1574943039000,"id":3954,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191128201039674","price":0.01},{"amount":1,"createTime":1574943039000,"id":3955,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191128201039847","price":0.01},{"amount":1,"createTime":1574943040000,"id":3956,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191128201040510","price":0.01},{"amount":1,"createTime":1574943313000,"id":3957,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191128201513459","price":0.01},{"amount":1,"createTime":1574943348000,"id":3958,"imageUrl":"http://172.17.8.100/images/movie/stills/whwdzg/whwdzg1.jpg","movieName":"我和我的祖国","orderId":"20191128201548690","price":0.01},{"amount":1,"createTime":1574943598000,"id":3959,"imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieName":"攀登者","orderId":"20191128201958420","price":0.01},{"amount":1,"createTime":1574943702000,"id":3960,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128202142082","price":0.01},{"amount":1,"createTime":1574943912000,"id":3961,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128202512518","price":0.01},{"amount":1,"createTime":1574944263000,"id":3962,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128203103839","price":0.01},{"amount":1,"createTime":1574945748000,"id":3974,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191128205548262","price":0.01},{"amount":1,"createTime":1574994857000,"id":4051,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129103417407","price":0.01},{"amount":1,"createTime":1574994858000,"id":4052,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129103418695","price":0.01},{"amount":1,"createTime":1574994859000,"id":4053,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129103419218","price":0.01},{"amount":1,"createTime":1574994989000,"id":4055,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129103629448","price":0.01},{"amount":1,"createTime":1574996399000,"id":4064,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129105958996","price":0.01},{"amount":1,"createTime":1574996629000,"id":4067,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129110349425","price":0.01},{"amount":1,"createTime":1574996699000,"id":4069,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129110459121","price":0.01},{"amount":1,"createTime":1574997042000,"id":4070,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129111042617","price":0.01},{"amount":1,"createTime":1574997536000,"id":4073,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129111856901","price":0.01},{"amount":1,"createTime":1574998270000,"id":4079,"imageUrl":"http://172.17.8.100/images/movie/stills/ws/ws1.jpg","movieName":"无双","orderId":"20191129113110232","price":0.15},{"amount":1,"createTime":1575032798000,"id":5066,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129210638360","price":0.01},{"amount":1,"createTime":1575032951000,"id":5070,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129210911195","price":0.01},{"amount":1,"createTime":1575081253000,"id":5319,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191130103413225","price":0.01}]
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
         * amount : 1
         * createTime : 1574939503000
         * id : 3942
         * imageUrl : http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg
         * movieName : 少年的你
         * orderId : 20191128191143240
         * price : 0.01
         */

        private int amount;
        private long createTime;
        private int id;
        private String imageUrl;
        private String movieName;
        private String orderId;
        private double price;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
