package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinePinglunBean;
import com.bw.movie.model.bean.FeedBackBean;
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
public class FeedbackPresent extends BeasPresent<ICountView.FeedbakView> {
    private HttpUtils utls;
    public void feedback(int userId,String sessionId,String content){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<FeedBackBean> feedbakc = aClass.Feedbakc(userId, sessionId, content);
        feedbakc.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<FeedBackBean>() {
                    @Override
                    public void call(FeedBackBean backBean) {
                        getView().FeedSuess(backBean);
                    }
                });

    }
}
