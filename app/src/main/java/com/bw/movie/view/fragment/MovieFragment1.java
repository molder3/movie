package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.BeonBean;
import com.bw.movie.model.bean.ComingBean;
import com.bw.movie.model.bean.HotmovieBean;
import com.bw.movie.model.bean.MakeBean;
import com.bw.movie.present.BannerPresent;
import com.bw.movie.view.activity.DimmovieActivity;
import com.bw.movie.view.activity.MoviedetailsActivity;
import com.bw.movie.view.adapter.CominAdapter;
import com.bw.movie.view.adapter.MovieRmdyAdapter;
import com.bw.movie.view.adapter.RmdyAdapter;
import com.bw.movie.view.adapter.XRccycler_Adapter;
import com.bw.movie.view.adapter.ZzryAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public class MovieFragment1 extends BeasFragment<BannerPresent> implements ICountView.XBannerView{
     private XRecyclerView asdas;
    /* private ImageView sous,dingw;
     private TextView beij;*/
    private List<BannerBean.ResultBean> result;
    private List<BeonBean.ResultBean> result1;
    private List<ComingBean.ResultBean> result2;
    private List<HotmovieBean.ResultBean> result3;
    private int ussid;
    private String ussisnid;
    private SharedPreferences.Editor edit;
    private String longitude;
    private String latitude;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = null;
    @Override
    protected int setLyout() {
        return R.layout.moviefragment1;
    }

    @Override
    protected void intiView() {
      //  dingw=getViewId(R.id.dingw);
      //  sous=getViewId(R.id.sous);
        asdas=getViewId(R.id.asdas);
       // beij=getViewId(R.id.beij);
        asdas.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected BannerPresent setPrsent() {
        return new BannerPresent();
    }

    @Override
    protected void intiData() {
        //轮播图
        fpresen.xbanne();
        //热门电影
        fpresen.moviehotrmsss();
        //即将上映
        SharedPreferences jin = getActivity().getSharedPreferences("jin",Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid",0);
        ussisnid = jin.getString("ussisnid", "");
        fpresen.moviecoming(ussid, ussisnid);
        fpresen.moviehotrm();
   /*     dingw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Loyudii();
            }
        });
        sous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), DimmovieActivity.class);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void Sucess(BannerBean bean) {
        result = bean.getResult();
        if (result!=null){
            XRccycler_Adapter adapter=new XRccycler_Adapter(result, result3, result1, result2, getActivity());
            asdas.setAdapter(adapter);
        }
    }

    @Override
    public void BeonSucess(BeonBean bean) {
        result1 = bean.getResult();
        if (result1!=null){
            XRccycler_Adapter adapter=new XRccycler_Adapter(result, result3, result1, result2, getActivity());
            asdas.setAdapter(adapter);
        }

    }

    @Override
    public void CominSucess(ComingBean bean) {
        result2 = bean.getResult();
        if (result2!=null){
            XRccycler_Adapter adapter=new XRccycler_Adapter(result, result3, result1, result2, getActivity());
            asdas.setAdapter(adapter);
        }
    }

    @Override
    public void HotMovieSucess(HotmovieBean bean) {
        result3 = bean.getResult();
        if (result3!=null){
            XRccycler_Adapter adapter=new XRccycler_Adapter(result, result3, result1, result2, getActivity());
            asdas.setAdapter(adapter);
        }
    }

    @Override
    public void MakkeSucess(MakeBean bean) {
        String status = bean.getStatus();

            Toast.makeText(getActivity(), bean.getMessage(), Toast.LENGTH_SHORT).show();

    }
    public void Loyudii(){
//初始化定位
        mLocationClient = new AMapLocationClient(getContext());
        //可以通过类implement方式实现AMapLocationListener接口，也可以通过创造接口类对象的方法实现
        //以下为后者的举例：
        mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        String district = amapLocation.getDistrict();//城区信息
                        String province = amapLocation.getProvince();//省信息
                        String city = amapLocation.getCity();//城市信息
                        String address = amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                        latitude = String.valueOf(amapLocation.getLatitude());
                        longitude = String.valueOf(amapLocation.getLongitude());
                        edit.putString("latitude",latitude);
                        edit.putString("longitude",longitude);
                        edit.commit();
                        Log.e("ldc", "district: " + district);
                        Log.e("ldc", "province: " + province);
                        Log.e("ldc", "city: " + city);
                        Log.e("ldc", "address: " + address);
                       /* beij.setText(address);
                        beij.setTextColor(android.graphics.Color.parseColor("#fff"));*/
                       /* if (province.length() > 0) {
                            beij.setText(province);
                        }*/
                        // 将城区信息存入sp
                        //SharedPreferencesUtil.getInstance().getSp().edit().putString(Constant.district, district).commit();


                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + amapLocation.getErrorCode() + ", errInfo:"
                                + amapLocation.getErrorInfo());
                    }
                }
            }
        };
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        AMapLocationClientOption option = new AMapLocationClientOption();
        /**
         * 设置定位场景，目前支持三种场景（签到、出行、运动，默认无场景）
         */
        option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.SignIn);
        if (null != mLocationClient) {
            mLocationClient.setLocationOption(option);
            //设置场景模式后最好调用一次stop，再调用start以保证场景模式生效
            mLocationClient.stopLocation();
            mLocationClient.startLocation();
        }
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
        //该方法默认为false。
        option.setOnceLocation(true);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        option.setOnceLocationLatest(true);
        //设置是否返回地址信息（默认返回地址信息）
        option.setNeedAddress(true);
        //设置是否允许模拟位置,默认为true，允许模拟位置
        option.setMockEnable(true);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        option.setHttpTimeOut(20000);
        //关闭缓存机制
        option.setLocationCacheEnable(false);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(option);
        //启动定位
        mLocationClient.startLocation();
    }
}
