package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.MovieLikeBean;
import com.bw.movie.model.bean.MovieNoLikeBean;
import com.bw.movie.model.bean.PbrqBean;
import com.bw.movie.model.bean.SetleBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class DetailsPresent extends BeasPresent<ICountView.Detalis> {
    private HttpUtils utls;
    public void detalis(int userId,String sessionId,int movieId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<DetailsBean> details = aClass.Details(userId, sessionId, movieId);
        details.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<DetailsBean>() {
                    @Override
                    public void call(DetailsBean detailsBean) {
                        getView().Succes(detailsBean);
                    }
                });
    }
    public void movielike(int userId,String sessionId,int movieId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<MovieLikeBean> like = aClass.MovieLike(userId, sessionId, movieId);
        like.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<MovieLikeBean>() {
                    @Override
                    public void call(MovieLikeBean bean) {
                        getView().MovieLikeSucess(bean);
                    }
                });
    }
    public void nomovielike(int userId,String sessionId,int movieId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<MovieNoLikeBean> movuiNolike = aClass.MovuiNolike(userId, sessionId, movieId);
        movuiNolike.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<MovieNoLikeBean>() {
                    @Override
                    public void call(MovieNoLikeBean bean) {

                    }
                });
    }

}
