package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CineGuanzBean;
import com.bw.movie.model.bean.ReserveBean;
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
public class ReserPresent extends BeasPresent<ICountView.ReserveView> {
    private HttpUtils utls;
    public void cinelike(int userId,String sessionId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<ReserveBean> reserv = aClass.Reserv(userId, sessionId);
        reserv.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<ReserveBean>() {
                    @Override
                    public void call(ReserveBean bean) {
                        getView().ReserveSucess(bean);
                    }
                });
    }
}
