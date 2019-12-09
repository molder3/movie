package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DimmovieBean;
import com.bw.movie.model.bean.PaiqiBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/30
 * author:金豪(Lenovo)
 * function:
 */
public class PaiDriPreset extends BeasPresent<ICountView.PdrqinView> {
    private HttpUtils utls;
    public void pdrqd(int cinemaId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<PaiqiBean> paidri = aClass.Paidri(cinemaId, 1, 10);
        paidri.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<PaiqiBean>() {
                    @Override
                    public void call(PaiqiBean bean) {
                        getView().PdriSuess(bean);
                    }
                });
    }
}
