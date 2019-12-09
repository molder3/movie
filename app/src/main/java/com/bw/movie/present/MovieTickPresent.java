package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.MovieLikegzBean;
import com.bw.movie.model.bean.MovieTickBean;
import com.bw.movie.model.bean.QRcodeBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/2
 * author:金豪(Lenovo)
 * function:
 */
public class MovieTickPresent extends BeasPresent<ICountView.MovieTickView> {
    private HttpUtils utls;
    public void movietick(int userId,String sessionId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<MovieTickBean> movieTickBeanObservable = aClass.MovieTick(userId, sessionId);
        movieTickBeanObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<MovieTickBean>() {
                    @Override
                    public void call(MovieTickBean bean) {
                        getView().MovieTickSucess(bean);
                    }
                });
    }
    //查询取票码
    public void qrcode(int userId,String sessionId,int recordId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<QRcodeBean> qRcodeB = aClass.QRcodeB(userId, sessionId, recordId);
        qRcodeB.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<QRcodeBean>() {
                    @Override
                    public void call(QRcodeBean qRcodeBean) {
                        getView().QRcodeSucess(qRcodeBean);
                    }
                });
    }
}
