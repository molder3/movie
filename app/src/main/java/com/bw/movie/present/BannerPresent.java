package com.bw.movie.present;

import android.text.method.Touch;
import android.util.Log;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.IBeasView;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.BeonBean;
import com.bw.movie.model.bean.ComingBean;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.model.bean.HotmovieBean;
import com.bw.movie.model.bean.MakeBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/12
 * author:金豪(Lenovo)
 * function:
 */
public class BannerPresent extends BeasPresent<ICountView.XBannerView> {
    private HttpUtils utls;

    public void xbanne() {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<BannerBean> banner = aClass.Banner();
        banner.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<BannerBean>() {
                    @Override
                    public void call(BannerBean bannerBean) {
                        getView().Sucess(bannerBean);
                    }
                });
    }

    //正在热映
    public void moviehotrmsss() {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<HotmovieBean> hotmovie = aClass.Hotmovie(1, 10);
        hotmovie.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<HotmovieBean>() {
                    @Override
                    public void call(HotmovieBean bean) {
                        getView().HotMovieSucess(bean);
                    }
                });
    }

    //即将上映
    public void moviecoming(int userId, String sessionId) {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<ComingBean> coming = aClass.Coming(userId, sessionId, 1, 4);
        coming.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<ComingBean>() {
                    @Override
                    public void call(ComingBean bean) {
                        getView().CominSucess(bean);
                    }
                });
    }

    //热门电影
    public void moviehotrm() {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<BeonBean> beon = aClass.Beon(1, 50);
        beon.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<BeonBean>() {
                    @Override
                    public void call(BeonBean beonBean) {
                        getView().BeonSucess(beonBean);
                    }
                });
    }
    public void mak(int userId, String sessionId,int movieId) {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<MakeBean> makeb = aClass.Makeb(userId, sessionId, movieId);
        makeb.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MakeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaa", "onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(MakeBean bean) {
                          getView().MakkeSucess(bean);
                    }
                });
    }
}
