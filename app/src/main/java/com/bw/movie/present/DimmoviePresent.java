package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.DimmovieBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/29
 * author:金豪(Lenovo)
 * function:
 */
public class DimmoviePresent extends BeasPresent<ICountView.DimmovieView> {
    private HttpUtils utls;
    public void dimmovie(String keyword,int count){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<DimmovieBean> dimovie = aClass.Dimovie(keyword, 1, count);
        dimovie.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<DimmovieBean>() {
                    @Override
                    public void call(DimmovieBean bean) {
                        getView().DimmovieSucess(bean);
                    }
                });
    }
}
