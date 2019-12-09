package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.MovieLikegzBean;
import com.bw.movie.model.bean.TickBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/3
 * author:金豪(Lenovo)
 * function:
 */
public class TickPrsent extends BeasPresent<ICountView.TickView> {
    private HttpUtils utls;
    public void tickd(int userId,String sessionId,int status){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<TickBean> tick = aClass.Tick(userId, sessionId, 1, 5, status);
        tick.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<TickBean>() {
                    @Override
                    public void call(TickBean bean) {
                        getView().TickSucess(bean);
                    }
                });
    }
}
