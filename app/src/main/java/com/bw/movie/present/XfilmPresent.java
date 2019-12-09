package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.XflimBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/28
 * author:金豪(Lenovo)
 * function:
 */
public class XfilmPresent extends BeasPresent<ICountView.XfilmView> {
    private HttpUtils utls;
    public void xfilm(int userId,String sessionId,int movieId,String commentContent,Double score){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<XflimBean> xflimBeanObservable = aClass.XFilm(userId, sessionId, movieId, commentContent, score);
        xflimBeanObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<XflimBean>() {
                    @Override
                    public void call(XflimBean xflimBean) {
                        getView().Sucess(xflimBean);
                    }
                });
    }
}
