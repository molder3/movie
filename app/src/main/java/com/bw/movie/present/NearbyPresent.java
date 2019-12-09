package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class NearbyPresent extends BeasPresent<ICountView.NearbyView> {
    private HttpUtils utls;
    public void nearby(int userId,String sessionId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<NearbyBean> nearby = aClass.Nearby(userId, sessionId, 1, 10);
        nearby.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<NearbyBean>() {
                    @Override
                    public void call(NearbyBean nearbyBean) {
                        getView().Sucess(nearbyBean);
                    }
                });

    }
}
