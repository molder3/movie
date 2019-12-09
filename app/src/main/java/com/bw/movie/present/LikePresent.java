package com.bw.movie.present;


import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.bean.RegionBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * data:2019/11/5
 * author:金豪(Lenovo)
 * function:
 */
public class LikePresent extends BeasPresent<ICountView.LikeView> {
    private HttpUtils utls;
    public void fjin(){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<QuyuBean> quyu = aClass.Quyu();
        quyu.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<QuyuBean>() {
                    @Override
                    public void call(QuyuBean quyuBean) {
                         getView().Suess(quyuBean);
                    }
                });

    }

    public void like(int regionId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<RegionBean> region = aClass.Region(regionId);
        region.observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new Action1<RegionBean>() {
                     @Override
                     public void call(RegionBean likeBean) {
                         getView().Suess(likeBean);
                     }
                 });

    }
}
