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
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
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
import com.bw.movie.view.adapter.ZzryAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public class MovieFragment extends BeasFragment<BannerPresent> implements ICountView.XBannerView{
    private XBanner xBanner;
    private List<BannerBean.ResultBean> result;
    private List<String> list=new ArrayList<>();
    private RecyclerView Zzry,Jjsy,rmdy,moview_rmdy;
    private CominAdapter cominAdapter;
    private RmdyAdapter rmdyAdapter;
    private MovieRmdyAdapter movieRmdyAdapter;
    private SharedPreferences moview;
    private SharedPreferences.Editor edit;
   // private List<HotBean.ResultBean> zzry;
    private EditText movie_ying;
    private ImageView sous,dingw;
    private String longitude;
    private String latitude;
    private TextView zz_gd,beij;
    private ZzryAdapter adapter;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = null;
    private int ussid;
    private String ussisnid;

    //声明AMapLocationClient类对象
   /* public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = null;*/
    @Override
    protected int setLyout() {
        return R.layout.moviefragment;
    }

    @Override
    protected void intiView() {
        //创建sp存入movie的id
        moview = getActivity().getSharedPreferences("jingw", Context.MODE_PRIVATE);
        edit = moview.edit();
        //获取资源id
        xBanner=getViewId(R.id.xbann);
        beij=getViewId(R.id.beij);
        movie_ying=getViewId(R.id.movie_ying);
        Zzry=getViewId(R.id.movie_zzyy);
        Jjsy=getViewId(R.id.movie_jjsy);
        rmdy=getViewId(R.id.movie_rmd);
        dingw=getViewId(R.id.dingw);
        moview_rmdy=getViewId(R.id.movie_rmdy);
        beij=getViewId(R.id.beij);
        sous=getViewId(R.id.sous);
        zz_gd=getViewId(R.id.zz_gd);
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        Zzry.setLayoutManager(layoutManager);*/
        Zzry.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        Jjsy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rmdy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        moview_rmdy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        Loyudii();
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
        dingw.setOnClickListener(new View.OnClickListener() {
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
        });
    }
    //轮播图
    @Override
    public void Sucess(BannerBean bean) {
        result = bean.getResult();
        //xbanner
     /*   for (int i = 0; i <result.size(); i++) {
            list.add(result.get(i).getImageUrl());
        }*/
        xBanner.setBannerData(R.layout.simpledraweeview, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int i) {
                return null;
            }

            @Override
            public int size() {
                return result.size();
            }
        });
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                String imageUrl = result.get(position).getImageUrl();
                SimpleDraweeView simpleDraweeView=view.findViewById(R.id.my_image_view);
                DraweeController  controller = Fresco.newDraweeControllerBuilder()
                        .setUri(imageUrl)
                        .setAutoPlayAnimations(true)
                        .build();
                simpleDraweeView.setController(controller);
                simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String jumpUrl = bean.getResult().get(position).getJumpUrl();
                        final List<String> strings = Arrays.asList(jumpUrl.split("="));
                        String s = strings.get(1);
                        int movieid = Integer.parseInt(s);
                        Intent intent=new Intent(getActivity(),MoviedetailsActivity.class);
                        intent.putExtra("movieId", movieid);
                        startActivity(intent);
                    }
                });
            }
        });
       /* xBanner.setData(list,null);
        xBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {

               // Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);
                SimpleDraweeView simpleDraweeView=view.findViewById(R.id.simp);
                DraweeController  controller = Fresco.newDraweeControllerBuilder()
                        .setUri(list.get(position))
                        .setAutoPlayAnimations(true)
                        .build();

            }
        });

        xBanner.setPageTransformer(Transformer.Cube);
        xBanner.setPageChangeDuration(1000);*/
    }

    //正在热映
    @Override
    public void HotMovieSucess(HotmovieBean bean) {
        adapter = new ZzryAdapter(bean.getResult(),getActivity());
        Zzry.setAdapter(adapter);
        //回调
        adapter.setItemClickListener(new ZzryAdapter.ItemClickListener() {
            @Override
            public void ItemClickListener(int movieid, String imageUrl) {
                Intent intent = new Intent(getActivity(), MoviedetailsActivity.class);
                intent.putExtra("movieId",movieid);

                startActivity(intent);
            }
        });
    }



    //即将上映
    @Override
    public void CominSucess(ComingBean bean) {
        cominAdapter = new CominAdapter(bean.getResult(),getActivity());
        Jjsy.setAdapter(cominAdapter);
        cominAdapter.setOnckieButnk(new CominAdapter.OnckieButnk() {
            @Override
            public void Onckedfklf(int movieId) {
                fpresen.mak(ussid, ussisnid,movieId);
            }
        });
        cominAdapter.setOnckieButnkkk(new CominAdapter.OnckieButnkkk() {
            @Override
            public void Onckedfklfkk(int movieId) {
                Intent intent = new Intent(getActivity(), MoviedetailsActivity.class);
                intent.putExtra("movieId",movieId);

                startActivity(intent);
            }
        });
    }
    @Override
    public void MakkeSucess(MakeBean bean) {
        String status = bean.getStatus();
        if (status!=null){
         Toast.makeText(getActivity(), bean.getMessage(), Toast.LENGTH_SHORT).show();
     }
    }
    //热门电影
    @Override
    public void BeonSucess(BeonBean bean) {
        rmdyAdapter = new RmdyAdapter(bean.getResult(),getActivity());
        rmdy.setAdapter(rmdyAdapter);
        movieRmdyAdapter=new MovieRmdyAdapter(bean.getResult(),getActivity());
        moview_rmdy.setAdapter(movieRmdyAdapter);
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
                        beij.setText(address);
                        beij.setTextColor(android.graphics.Color.parseColor("#fff"));
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
