package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.MovieLikegzBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/12/1
 * author:金豪(Lenovo)
 * function:
 */
public class MovieLikegzPresent extends BeasPresent<ICountView.MoviLikeView> {
    private HttpUtils utls;
    public void guanzhu(int userId,String sessionId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<MovieLikegzBean> guanzhu = aClass.Guanzhu(userId, sessionId, 1, 10);
        guanzhu.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<MovieLikegzBean>() {
                    @Override
                    public void call(MovieLikegzBean bean) {
                        getView().MovielikeSUcess(bean);
                    }
                });
    }
}
