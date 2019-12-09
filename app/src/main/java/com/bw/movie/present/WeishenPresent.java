package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.RecommendBean;
import com.bw.movie.model.bean.WeisheBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/18
 * author:金豪(Lenovo)
 * function:
 */
public class WeishenPresent extends BeasPresent<ICountView.WeiView> {
    private HttpUtils utls;
    public void weishe(int userId,String sessionId,int commentId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<WeisheBean> weish = aClass.Weish(userId, sessionId, commentId, 1, 5);
        weish.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<WeisheBean>() {
                    @Override
                    public void call(WeisheBean weisheBean) {
                        getView().Sucess(weisheBean);
                    }
                });

    }
}
