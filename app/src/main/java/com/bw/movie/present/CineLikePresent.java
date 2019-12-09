package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CineGuanzBean;
import com.bw.movie.model.bean.MovieLikegzBean;
import com.bw.movie.model.bean.QuxiaoguanzBean;
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
public class CineLikePresent extends BeasPresent<ICountView.CineLikeView> {
    private HttpUtils utls;
    public void cinelike(int userId,String sessionId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<CineGuanzBean> cineGuanz = aClass.CineGuanz(userId, sessionId, 1, 10);
        cineGuanz.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<CineGuanzBean>() {
                    @Override
                    public void call(CineGuanzBean cineGuanzBean) {
                        getView().CoinelikeSUcess(cineGuanzBean);
                    }
                });
    }
    public void quxiaoguanzh(int userId, String sessionId,int cinemaId){
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
