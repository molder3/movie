package com.bw.movie.contract;

import android.view.View;

import com.bw.movie.model.RecommendBean;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.BeonBean;
import com.bw.movie.model.bean.BirthdayBean;
import com.bw.movie.model.bean.ByPriceBean;
import com.bw.movie.model.bean.CineGuanzBean;
import com.bw.movie.model.bean.CinePinglunBean;
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
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.bean.RegionBean;
import com.bw.movie.model.bean.NearbyBean;
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

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public interface ICountView {
    //登录
    interface LoginView extends IBeasView{
        void Sucess(LoginBean bean);
        void WxSucess(WxBean bean);
    }
    //注册
    interface RegisterView extends IBeasView{
        void Succeed(RegisterBean bean);
        //发送验证码
        void Succee(CodeBean bean);
    }
    //写评论
    interface XfilmView extends IBeasView{
        void Sucess(XflimBean bean);
    }
    //查询新版本
    interface VersionsView extends IBeasView{
        void Succeed(VersionsBean bean);
    }
    //轮播图
    interface XBannerView extends IBeasView {
        void Sucess(BannerBean bean);
         void BeonSucess(BeonBean bean);
        void CominSucess(ComingBean bean);
        void HotMovieSucess(HotmovieBean bean);
        void MakkeSucess(MakeBean bean);
       // void MohudySucess(MohudyBean bean);
    }
    //电影详情
    interface Detalis extends IBeasView{
        void Succes(DetailsBean bean);
        void MovieLikeSucess(MovieLikeBean bean);
        void MovieNolieSunse(MovieNoLikeBean bean);
        //void Xuanz(SetleBean bean);
        //void Pbrq(PbrqBean bean);
    }
    interface Deta extends IBeasView{
        void Xuanz(SetleBean bean);
        void Pbrq(PbrqBean bean);
        void Succes(DetailsBean bean);
        void TicketsSuce(TicketsBean bean);
        void WxzfSucess(WxzfpriceBean bean);
    }
    //选座
    interface DetalisView extends IBeasView{
        void Succes(DetailsBean bean);
        void Suvess(QuyuBean bean);
        void TimeSuess(TimeBean bean);
        void BypriceSuess(ByPriceBean bean);
        //void Xuanz(SetleBean bean);
        //void Pbrq(PbrqBean bean);
    }
    //推荐影院
   interface NearbyView extends IBeasView{
        void Sucess(NearbyBean bean);
    }
    //附近影院
    interface RecoView extends IBeasView{
        void Sucees(RecommendBean bean);
    }
    //影院详情
    interface CinemaView extends IBeasView{
        void Sucees(CinemaBean bean);
        void GuasnzhuSuces(GuanzhucineBean bean);
        void QuxiaoSucess(QuxiaoguanzBean bean);
    }
    //查询影评
    interface WeiView extends IBeasView{
        void Sucess(WeisheBean bean);
    }
    interface LikeView extends IBeasView{
        void Suess(RegionBean bean);
        void Suess(QuyuBean bean);
    }
    //影院详情
    interface CinePingView extends IBeasView{
        void PingSucess(CinePinglunBean bean);
    }
    //根据关键字查询电影信息
    interface DimmovieView extends IBeasView{
        void DimmovieSucess(DimmovieBean bean);
    }
    //查询排挡日期
    interface PdrqinView extends IBeasView{
        void PdriSuess(PaiqiBean bean);
    }
   //查询用户关注电影列表
    interface MoviLikeView extends IBeasView{
        void MovielikeSUcess(MovieLikegzBean bean);
   }
    //查询用户关注影院列表
    interface CineLikeView extends IBeasView{
        void CoinelikeSUcess(CineGuanzBean bean);
        void QuxiaoSucess(QuxiaoguanzBean bean);
    }
    //查询用户预约的电影
    interface ReserveView extends IBeasView{
        void ReserveSucess(ReserveBean bean);
    }
    //我的电影票
    interface MovieTickView extends IBeasView{
        void MovieTickSucess(MovieTickBean bean);
        void QRcodeSucess(QRcodeBean bean);
    }
    //意见反馈
    interface FeedbakView extends IBeasView{
        void FeedSuess(FeedBackBean bean);
    }
    //购票记录
    interface TickView extends IBeasView{
        void TickSucess(TickBean bean);
    }
    //图片上传
    interface UploadingView extends IBeasView{
        void UploadingSuess(UploadingBean bean);
        void IUserSuess(IUserBean bean);
        void BirthdaySun(BirthdayBean bean);
    }
    //查询我对电影的评论列表
    interface MovieCiView  extends IBeasView{
        void MviwegSuess(MoviePingLunBean bean);
    }
    //查询我对影院的评论列表
    interface CinemaPiView  extends IBeasView{
        void CinemaSuess(CinemaPingBean bean);
    }
    //看过的电影
    interface KanguoView extends  IBeasView{
        void KanguoSuness(KanguoMovieBean bean);
    }
    //系统消息
    interface SystemView extends IBeasView{
        void SystemSuces(SystemBean bean);
    }
}
