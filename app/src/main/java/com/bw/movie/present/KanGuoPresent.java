package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.FeedBackBean;
import com.bw.movie.model.bean.KanguoMovieBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/5
 * author:金豪(Lenovo)
 * function:
 */
public class KanGuoPresent extends BeasPresent<ICountView.KanguoView> {
    private HttpUtils utls;
    public void kanguo(int userId,String sessionId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<KanguoMovieBean> kanguoBean = aClass.KanguoBean(userId, sessionId);
        kanguoBean.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<KanguoMovieBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(KanguoMovieBean bean) {
                            getView().KanguoSuness(bean);
                    }
                });

    }
}
