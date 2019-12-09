package com.bw.movie.present;

import com.bw.movie.api.APiService;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.PbrqBean;
import com.bw.movie.model.bean.SetleBean;
import com.bw.movie.model.bean.TicketsBean;
import com.bw.movie.model.bean.WxzfpriceBean;
import com.bw.movie.model.utils.HttpUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * date:2019/11/20
 * author:金豪(Lenovo)
 * function:
 */
public class DetailPresent extends BeasPresent<ICountView.Deta> {
    private HttpUtils utls;
    public void datad(int userId,String sessionId,int movieId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<DetailsBean> details = aClass.Details(userId, sessionId, movieId);
        details.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<DetailsBean>() {
                    @Override
                    public void call(DetailsBean detailsBean) {
                        getView().Succes(detailsBean);
                    }
                });
    }
    public void setl(int hallId){
        utls=HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<SetleBean> setbn = aClass.Setbn(hallId);
        setbn.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<SetleBean>() {
                    @Override
                    public void call(SetleBean setleBean) {
                        getView().Xuanz(setleBean);
                    }
                });
    }
    public void pdsa(int movieId,int hallId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<PbrqBean> pasdd = aClass.Pasdd(movieId, hallId);
        pasdd.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<PbrqBean>() {
                    @Override
                    public void call(PbrqBean pbrqBean) {
                        getView().Pbrq(pbrqBean);
                    }
                });
    }
    public void tickls(int userId,String sessionId,int scheduleId,String seat,String sign){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<TicketsBean> tickets = aClass.Tickets(userId, sessionId, scheduleId, seat, sign);
        tickets.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<TicketsBean>() {
                    @Override
                    public void call(TicketsBean ticketsBean) {
                        getView().TicketsSuce(ticketsBean);
                    }
                });
    }
    public void wxzfp(int userId,String sessionId,String orderId){
        utls= HttpUtils.getUtls();
        APiService aClass = utls.getClass(APiService.class);
        Observable<WxzfpriceBean> wxzf = aClass.Wxzf(userId, sessionId, 1, orderId);
        wxzf.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<WxzfpriceBean>() {
                    @Override
                    public void call(WxzfpriceBean bean) {
                        getView().WxzfSucess(bean);
                    }
                });
    }
}
