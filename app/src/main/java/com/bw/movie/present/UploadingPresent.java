package com.bw.movie.present;

import android.util.Log;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.BirthdayBean;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.IUserBean;
import com.bw.movie.model.bean.UploadingBean;
import com.bw.movie.model.utils.HttpUtils;

import java.util.List;

import okhttp3.MultipartBody;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/3
 * author:金豪(Lenovo)
 * function:
 */
public class UploadingPresent extends BeasPresent<ICountView.UploadingView> {
    private HttpUtils utls;
    public void cinema(int userId, String sessionId, MultipartBody.Part image){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<UploadingBean> uploadin = aClass.Uploadin(userId, sessionId, image);
        uploadin.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UploadingBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("tag",""+e);
                    }

                    @Override
                    public void onNext(UploadingBean bean) {
                         getView().UploadingSuess(bean);
                    }
                });
    }
    public void iuserb(int userId, String sessionId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<IUserBean> iusert = aClass.Iusert(userId, sessionId);
        iusert.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<IUserBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(IUserBean bean) {
                          getView().IUserSuess(bean);
                    }
                });
    }
    public void birthp(int userId, String sessionId,String birthday){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<BirthdayBean> birthday1 = aClass.Birthday(userId, sessionId, birthday);
        birthday1.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<BirthdayBean>() {
                    @Override
                    public void call(BirthdayBean birthdayBean) {
                        getView().BirthdaySun(birthdayBean);
                    }
                });
    }
}
