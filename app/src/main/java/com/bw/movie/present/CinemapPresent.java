package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinemaPingBean;
import com.bw.movie.model.bean.MoviePingLunBean;
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
public class CinemapPresent extends BeasPresent<ICountView.CinemaPiView> {
    private HttpUtils utls;
    public void cinemap(int userId,String sessionId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<CinemaPingBean> cinemaPing = aClass.CinemaPing(userId, sessionId, "0", "0", 1, 5);
        cinemaPing.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CinemaPingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CinemaPingBean cinemaPingBean) {
                          getView().CinemaSuess(cinemaPingBean);
                    }
                });
    }
}
