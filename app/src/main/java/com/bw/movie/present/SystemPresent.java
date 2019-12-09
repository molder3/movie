package com.bw.movie.present;

import android.util.Log;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.MoviePingLunBean;
import com.bw.movie.model.bean.SystemBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/6
 * author:金豪(Lenovo)
 * function:
 */
public class SystemPresent extends BeasPresent<ICountView.SystemView> {
    private HttpUtils utls;
    public void stysem(int userId,String sessionId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<SystemBean> system = aClass.System(userId, sessionId, 1, 10);
        system.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SystemBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SystemBean bean) {
                         getView().SystemSuces(bean);
                    }
                });
    }

}
