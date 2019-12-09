package com.bw.movie.present.loginregister;

import androidx.core.util.Consumer;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.loginregister.RegisterBean;
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
public class RegisterPresent extends BeasPresent<ICountView.RegisterView> {
    private HttpUtils utls;

    public void regiser(String nickName, String pwd, String email, String code) {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<RegisterBean> ring = aClass.Ring(nickName, pwd, email, code);
        ring.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<RegisterBean>() {
                    @Override
                    public void call(RegisterBean registerBean) {
                        getView().Succeed(registerBean);
                    }
                });
    }

    public void noted(String email) {
        utls = HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<CodeBean> note = aClass.Note(email);
        note.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<CodeBean>() {
                    @Override
                    public void call(CodeBean codeBean) {
                        getView().Succee(codeBean);
                    }
                });
    }
}
