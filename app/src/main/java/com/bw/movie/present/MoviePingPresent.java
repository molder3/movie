package com.bw.movie.present;

import android.util.Log;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.MoviePingLunBean;
import com.bw.movie.model.bean.MovieTickBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/4
 * author:金豪(Lenovo)
 * function:
 */
public class MoviePingPresent extends BeasPresent<ICountView.MovieCiView> {
    private HttpUtils utls;
    public void moviep(int userId,String sessionId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<MoviePingLunBean> moviePingl = aClass.MoviePingl(userId, sessionId, 1, 10);
        moviePingl.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MoviePingLunBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ddd",e.getMessage());
                    }

                    @Override
                    public void onNext(MoviePingLunBean moviePingLunBean) {
                          getView().MviwegSuess(moviePingLunBean);
                    }
                });
    }
}
