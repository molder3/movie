package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinePinglunBean;
import com.bw.movie.model.bean.WeisheBean;
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
public class CinepingPresent extends BeasPresent<ICountView.CinePingView> {
    private HttpUtils utls;
    public void coinep(int userId,String sessionId,int commentId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<CinePinglunBean> cine = aClass.CinePingl(userId, sessionId, commentId, 1, 5);
        cine.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<CinePinglunBean>() {
                    @Override
                    public void call(CinePinglunBean bean) {
                        getView().PingSucess(bean);
                    }
                });

    }
}
