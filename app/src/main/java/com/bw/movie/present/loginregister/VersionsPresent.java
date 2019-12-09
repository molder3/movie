package com.bw.movie.present.loginregister;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.loginregister.VersionsBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public class VersionsPresent extends BeasPresent<ICountView.VersionsView> {
    private HttpUtils utls;

    public void versions(int userId, String sessionId, String ak) {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<VersionsBean> version = aClass.Versions(userId, sessionId, ak);
        version.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<VersionsBean>() {
                    @Override
                    public void call(VersionsBean versionsBean) {
                        getView().Succeed(versionsBean);
                    }
                });
    }
}
