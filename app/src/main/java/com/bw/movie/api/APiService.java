package com.bw.movie.api;

import com.bw.movie.model.RecommendBean;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.BeonBean;
import com.bw.movie.model.bean.BirthdayBean;
import com.bw.movie.model.bean.ByPriceBean;

import com.bw.movie.model.bean.CineGuanzBean;
import com.bw.movie.model.bean.CinePinglunBean;
import com.bw.movie.model.bean.CinecommentBean;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.CinemaPingBean;
import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.ComingBean;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.DimmovieBean;
import com.bw.movie.model.bean.FeedBackBean;
import com.bw.movie.model.bean.GuanzhucineBean;
import com.bw.movie.model.bean.HotmovieBean;
import com.bw.movie.model.bean.IUserBean;
import com.bw.movie.model.bean.KanguoMovieBean;
import com.bw.movie.model.bean.MakeBean;
import com.bw.movie.model.bean.MovieLikeBean;
import com.bw.movie.model.bean.MovieLikegzBean;
import com.bw.movie.model.bean.MovieNoLikeBean;
import com.bw.movie.model.bean.MoviePingLunBean;
import com.bw.movie.model.bean.MovieTickBean;
import com.bw.movie.model.bean.PaiqiBean;
import com.bw.movie.model.bean.PbrqBean;
import com.bw.movie.model.bean.QRcodeBean;
import com.bw.movie.model.bean.QuxiaoguanzBean;
import com.bw.movie.model.bean.RegionBean;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.bean.ReserveBean;
import com.bw.movie.model.bean.SetleBean;
import com.bw.movie.model.bean.SystemBean;
import com.bw.movie.model.bean.TickBean;
import com.bw.movie.model.bean.TicketsBean;
import com.bw.movie.model.bean.TimeBean;
import com.bw.movie.model.bean.UploadingBean;
import com.bw.movie.model.bean.WeisheBean;
import com.bw.movie.model.bean.WxBean;
import com.bw.movie.model.bean.WxzfpriceBean;
import com.bw.movie.model.bean.XflimBean;
import com.bw.movie.model.bean.loginregister.LoginBean;
import com.bw.movie.model.bean.loginregister.RegisterBean;
import com.bw.movie.model.bean.loginregister.VersionsBean;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import rx.Observable;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public interface APiService {
    //登录
    @FormUrlEncoded
    @POST("movieApi/user/v2/login")
    Observable<LoginBean> Long(@Field("email") String email, @Field("pwd") String pwd);
    @FormUrlEncoded
    @POST("movieApi/user/v1/weChatBindingLogin")
    Observable<WxBean> Wxbe(@Field("code") String code);
    //注册
    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<RegisterBean> Ring(@Field("nickName") String nickName, @Field("pwd") String pwd, @Field("email") String email, @Field("code") String code);
    //发送验证码
    @FormUrlEncoded
    @POST("movieApi/user/v2/sendOutEmailCode")
    Observable<CodeBean> Note(@Field("email") String email);
    //查询新版本
    @GET("movieApi/tool/v1/findNewVersion")
    Observable<VersionsBean> Versions(@Header("userId") int userId, @Header("sessionId") String sessionId, @Header("ak") String ak);
    //轮播图
    @GET("movieApi/tool/v2/banner")
    Observable<BannerBean> Banner();
    //正在上映
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<HotmovieBean> Hotmovie(@Query("page") int page, @Query("count") int count);
    //热门电影
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<BeonBean> Beon(@Query("page") int page, @Query("count") int count);
    //即将上映
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<ComingBean> Coming(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("page") int page, @Query("count") int count);
    //推荐影院
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<NearbyBean> Nearby(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("page") int page, @Query("count") int count);
    //附近影院
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<RecommendBean> Recommend(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("longitude") String longitude	, @Query("latitude") String latitude, @Query("page") int page, @Query("count") int count);
    //电影详情
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<DetailsBean> Details(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("movieId") int movieId);
    @Streaming
    @GET("media/movie.apk")
    Observable<ResponseBody> onDownLoad(@Header("RANGE") String start);
    //影院详情
    @GET("movieApi/cinema/v1/findCinemaInfo")
    Observable<CinemaBean> Cinema(@Header("userId") int userId, @Header("sessionId") String sessionId,@Query("cinemaId") int cinemaId);
    //查看评论
    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<WeisheBean> Weish(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("movieId") int movieId, @Query("page") int page, @Query("count") int count);
     //写评论
     @FormUrlEncoded
     @POST("movieApi/movie/v1/verify/movieComment")
     Observable<XflimBean> XFilm(@Header("userId") int userId, @Header("sessionId") String sessionId, @Field("movieId") int movieId, @Field("commentContent") String commentContent, @Field("score") double score);
    //选座
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<SetleBean> Setbn(@Query("hallId") int hallId);
    //根据电影id和影院id差
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<PbrqBean> Pasdd(@Query("movieId") int movieId, @Query("cinemaId") int cinemaId);
    //根据电影价格查询播放影院信息
    @GET("movieApi/movie/v2/findCinemasInfoByPrice")
    Observable<ByPriceBean> ByPrice(@Query("movieId") int movieId,@Query("page") int page, @Query("count") int count);
   //购票下单
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/buyMovieTickets")
    Observable<TicketsBean> Tickets(@Header("userId") int userId, @Header("sessionId") String sessionId,@Field("scheduleId") int scheduleId,@Field("seat") String seat,@Field("sign") String sign);
    //支付
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/pay")
    Observable<WxzfpriceBean> Wxzf(@Header("userId") int userId, @Header("sessionId") String sessionId,@Field("payType") int payType,@Field("orderId") String orderId);
    @GET("movieApi/cinema/v2/findCinemaByRegion")
    Observable<RegionBean> Region(@Query("regionId") int regionId);
    //查询影院用户评论列表
    @GET("movieApi/cinema/v1/findAllCinemaComment")
    Observable<CinePinglunBean> CinePingl(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("cinemaId") int cinemaId, @Query("page") int page, @Query("count") int count);
    //根据关键字查询电影信息
    @GET("movieApi/movie/v2/findMovieByKeyword")
    Observable<DimmovieBean> Dimovie(@Query("keyword") String keyword,@Query("page") int page, @Query("count") int count);
    //查询电影排挡日期
    @GET("movieApi/cinema/v2/findCinemaScheduleList")
    Observable<PaiqiBean> Paidri(@Query("cinemaId") int cinemaId,@Query("page") int page, @Query("count") int count);
    //查询区域列表
    @GET("movieApi/tool/v2/findRegionList")
    Observable<QuyuBean> Quyu();
    //关注电影
    @GET("movieApi/movie/v1/verify/followMovie")
    Observable<MovieLikeBean> MovieLike(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("movieId") int movieId);
    //取消关注电影
    @GET("movieApi/movie/v1/verify/cancelFollowMovie")
    Observable<MovieNoLikeBean> MovuiNolike(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("movieId") int movieId);
    //查询用户关注电影列表
    @GET("movieApi/user/v2/verify/findUserFollowMovieList")
    Observable<MovieLikegzBean> Guanzhu(@Header("userId") int userId, @Header("sessionId") String sessionId,@Query("page") int page, @Query("count") int count);
    //关注影院
    @GET("movieApi/cinema/v1/verify/followCinema")
    Observable<GuanzhucineBean> GuanzhuY(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("cinemaId") int cinemaId);
    //取消关注影院
    @GET("movieApi/cinema/v1/verify/cancelFollowCinema")
    Observable<QuxiaoguanzBean> QiaoxgyuanY(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("cinemaId") int cinemaId);
    //查询用户关注影院列表
    @GET("movieApi/user/v2/verify/findUserFollowCinemaList")
    Observable<CineGuanzBean> CineGuanz(@Header("userId") int userId, @Header("sessionId") String sessionId,@Query("page") int page, @Query("count") int count);
    //预约
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/reserve")
    Observable<MakeBean> Makeb(@Header("userId") int userId, @Header("sessionId") String sessionId,@Field("movieId") int movieId);
    //查询用户预约电影信息
    @GET("movieApi/user/v2/verify/findUserReserve")
   Observable<ReserveBean> Reserv(@Header("userId") int userId, @Header("sessionId") String sessionId);
    //我的电影票
    @GET("movieApi/user/v2/verify/findMyMovieTicket")
    Observable<MovieTickBean> MovieTick(@Header("userId") int userId, @Header("sessionId") String sessionId);
    @FormUrlEncoded
    @POST("movieApi/tool/v1/verify/recordFeedBack")
    Observable<FeedBackBean> Feedbakc(@Header("userId") int userId, @Header("sessionId") String sessionId,@Field("content") String content);
    //购票记录
    @GET("movieApi/user/v2/verify/findUserBuyTicketRecord")
    Observable<TickBean> Tick(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("page") int page, @Query("count") int count,@Query("status") int status);
    //图片上传
    @Multipart
    @POST("movieApi/user/v1/verify/uploadHeadPic")
    Observable<UploadingBean>  Uploadin(@Header("userId") int userId, @Header("sessionId") String sessionId,@Part("image") MultipartBody.Part file);
    //根据用户ID查询用户信息
    @GET("movieApi/user/v1/verify/getUserInfoByUserId")
    Observable<IUserBean> Iusert(@Header("userId") int userId, @Header("sessionId") String sessionId);
    //查询取票
    @GET("movieApi/user/v2/verify/findExchangeCode")
    Observable<QRcodeBean> QRcodeB(@Header("userId") int userId, @Header("sessionId") String sessionId,@Query("recordId") int recordId);
    //我队电影评论
    @GET("movieApi/user/v2/verify/findMyMovieCommentList")
    Observable<MoviePingLunBean> MoviePingl(@Header("userId") int userId, @Header("sessionId") String sessionId,@Query("page") int page, @Query("count") int count);
    //我对影院的评论
    @GET("movieApi/user/v2/verify/findMyCinemaCommentList")
    Observable<CinemaPingBean> CinemaPing(@Header("userId") int userId, @Header("sessionId") String sessionId,@Header("longitude") String longitude, @Header("latitude") String latitude,@Query("page") int page, @Query("count") int count);
    //看过的电影
    @GET("movieApi/user/v2/verify/findSeenMovie")
    Observable<KanguoMovieBean> KanguoBean(@Header("userId") int userId, @Header("sessionId") String sessionId);
    //修改出生日期
    @FormUrlEncoded
    @POST("movieApi/user/v2/verify/updateUserBirthday")
    Observable<BirthdayBean> Birthday(@Header("userId") int userId, @Header("sessionId") String sessionId,@Field("birthday") String birthday);
    //系统消息
    @GET("movieApi/tool/v1/verify/findAllSysMsgList")
    Observable<SystemBean> System(@Header("userId") int userId, @Header("sessionId") String sessionId,@Query("page") int page, @Query("count") int count);
    @GET("movieApi/tool/v2/findDateList")
    Observable<TimeBean> Time();
}
