package com.bw.movie.present.loginregister;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.WxBean;
import com.bw.movie.model.bean.loginregister.LoginBean;
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
public class LoginPresent extends BeasPresent<ICountView.LoginView> {
    private HttpUtils utls;

    public void Login(String email, String pwd) {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<LoginBean> aLong = aClass.Long(email, pwd);
        aLong.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<LoginBean>() {
                    @Override
                    public void call(LoginBean loginBean) {
                        getView().Sucess(loginBean);
                    }
                });
    }
    public void Wxde(String code) {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<WxBean> wxbe = aClass.Wxbe(code);
        wxbe.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<WxBean>() {
                    @Override
                    public void call(WxBean bean) {
                        getView().WxSucess(bean);
                    }
                });
    }
}
