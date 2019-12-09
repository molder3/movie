package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.RecommendBean;
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
public class RecommendPresent extends BeasPresent<ICountView.RecoView> {
    private HttpUtils utls;
    public void recomm(int userId,String sessionId,String longitude,String latitude){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<RecommendBean> recommend = aClass.Recommend(userId, sessionId, longitude, latitude, 1, 10);
        recommend.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<RecommendBean>() {
                    @Override
                    public void call(RecommendBean recommendBean) {
                        getView().Sucees(recommendBean);
                    }
                });

    }
}
