package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.GuanzhucineBean;
import com.bw.movie.model.bean.QuxiaoguanzBean;
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/14
 * author:金豪(Lenovo)
 * function:
 */
public class CinemaPresent extends BeasPresent<ICountView.CinemaView> {
    private HttpUtils utls;
    public void cinema(int userId, String sessionId,int cinemaId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<CinemaBean> cinema = aClass.Cinema(userId, sessionId, cinemaId);
        cinema.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<CinemaBean>() {
                    @Override
                    public void call(CinemaBean cinemaBean) {
                        getView().Sucees(cinemaBean);
                    }
                });
    }
    public void guanzhu(int userId, String sessionId,int cinemaId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<GuanzhucineBean> guanzhuY = aClass.GuanzhuY(userId, sessionId, cinemaId);
        guanzhuY.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<GuanzhucineBean>() {
                    @Override
                    public void call(GuanzhucineBean bean) {
                        getView().GuasnzhuSuces(bean);
                    }
                });
    }
    public void quxiaoguanzhu(int userId, String sessionId,int cinemaId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<QuxiaoguanzBean> quxiaoguanzBeanObservable = aClass.QiaoxgyuanY(userId, sessionId, cinemaId);
        quxiaoguanzBeanObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<QuxiaoguanzBean>() {
                    @Override
                    public void call(QuxiaoguanzBean bean) {
                        getView().QuxiaoSucess(bean);
                    }
                });
    }
}
