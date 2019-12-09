package com.bw.movie.present.xuandetails;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.ByPriceBean;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.bean.TimeBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/20
 * author:金豪(Lenovo)
 * function:
 */
public class XuanDetailsPresent extends BeasPresent<ICountView.DetalisView> {
    private HttpUtils utls;
    public void detalisview(int userId,String sessionId,int movieId){
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
    public void fjinview(){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<QuyuBean> quyu = aClass.Quyu();
        quyu.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<QuyuBean>() {
                    @Override
                    public void call(QuyuBean quyuBean) {
                        getView().Suvess(quyuBean);
                    }
                });

    }
    public void tiemi() {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<TimeBean> time = aClass.Time();
        time.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<TimeBean>() {
                    @Override
                    public void call(TimeBean bean) {
                        getView().TimeSuess(bean);
                    }
                });
    }
    public void byprice(int movieId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<ByPriceBean> byPriceBeanObservable = aClass.ByPrice(movieId, 1, 10);
        byPriceBeanObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<ByPriceBean>() {
                    @Override
                    public void call(ByPriceBean byPriceBean) {
                        getView().BypriceSuess(byPriceBean);
                    }
                });

    }
}
