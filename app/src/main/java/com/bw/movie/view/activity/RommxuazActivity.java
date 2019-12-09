package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.MyApplication;
import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.PbrqBean;
import com.bw.movie.model.bean.SetleBean;
import com.bw.movie.model.bean.TicketsBean;
import com.bw.movie.model.bean.WxzfpriceBean;
import com.bw.movie.present.DetailPresent;
import com.bw.movie.present.DetailsPresent;
import com.bw.movie.view.adapter.MovieSeatAdapter;
import com.bw.movie.view.adapter.PdrqAdapter;
import com.tencent.mm.opensdk.modelpay.PayReq;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class RommxuazActivity extends BeasActivity<DetailPresent> implements ICountView.Deta {


    @BindView(R.id.room_back)
    ImageView roomBack;
    @BindView(R.id.room_name)
    TextView roomName;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.room_VideoPlayer)
    JCVideoPlayer roomVideoPlayer;
    @BindView(R.id.real)
    RelativeLayout real;
    @BindView(R.id.room_time)
    TextView roomTime;
    @BindView(R.id.radio_wx)
    RadioButton radioWx;
    @BindView(R.id.radio_zzfb)
    RadioButton radioZzfb;
    @BindView(R.id.room_btn)
    Button roomBtn;
     private Button btnPurchaseOrder;
     private LinearLayout linerLay;
     private RecyclerView roomMovieSeat,roomRecycler;
     private ImageView imagGb;
    private MovieSeatAdapter adapter;
    private String string;
    private long sum;
    private double fare=0.1;
    private double zf;
    private CheckBox wxzf;
    private int cinemaId;
    private List<SetleBean.ResultBean> result;
    private int ussid;
    private String ussisnid;
    private String orderId;
    private int idd1;

    @Override
    protected int setLyout() {
        return R.layout.activity_rommxuaz;
    }

    @Override
    protected void inttView() {
        imagGb=findViewById(R.id.imag_gb);
        btnPurchaseOrder=findViewById(R.id.btn_purchaseOrder);
        roomMovieSeat=findViewById(R.id.room_movieSeat);
        linerLay=findViewById(R.id.liner_lay);
        roomRecycler=findViewById(R.id.room_recycler);
        roomRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    protected DetailPresent Present() {
        return new DetailPresent();
    }

    @Override
    protected void inttData() {
        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
        SharedPreferences hao = getSharedPreferences("hao", Context.MODE_PRIVATE);
        int movieid = hao.getInt("movieid", 0);
       /* SharedPreferences moview = getSharedPreferences("moview", Context.MODE_PRIVATE);
        int movieId = moview.getInt("movieId", 0);*/
        Intent intent = getIntent();
        int hllid = intent.getIntExtra("hllid", 0);

        present.datad(ussid, ussisnid,movieid);
        present.pdsa(movieid,hllid);
        btnPurchaseOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerLay.setVisibility(View.VISIBLE);
            }
        });
        btnPurchaseOrder.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                linerLay.setVisibility(View.GONE);
                return true;
            }
        });


        imagGb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerLay.setVisibility(View.GONE);
            }
        });
        roomMovieSeat.setLayoutManager(new GridLayoutManager(this,8));

    }

    @Override
    public void Xuanz(SetleBean bean) {
        result = bean.getResult();
        adapter = new MovieSeatAdapter(bean.getResult(),this);
        roomMovieSeat.setAdapter(adapter);
        adapter.setCallBack(new MovieSeatAdapter.CallBack() {
            @Override
            public void getBack(String s) {
                Toast.makeText(RommxuazActivity.this, s, Toast.LENGTH_SHORT).show();
                string = s;
                for (int i = 0; i < result.size(); i++) {
                    if (result.get(i).getStatus() == 3) {
                        sum++;
                    }
                }
                if (sum > 4) {
                    Toast.makeText(RommxuazActivity.this, "最多" + sum + "张", Toast.LENGTH_SHORT).show();

                } else {
                    //设置价格
                    if (sum != 0) {
                        zf = sum * fare;
                        btnPurchaseOrder.setText("￥:" + sum * fare);
                        btnPurchaseOrder.setVisibility(View.VISIBLE);
                        roomBtn.setVisibility(View.INVISIBLE);
                        sum = 0;
                    } else if (sum == 0) {
                        roomBtn.setVisibility(View.VISIBLE);
                        btnPurchaseOrder.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void getStrng(ArrayList<String> list) {
                String str = null;
                for (int i = 0; i < list.size(); i++) {
                    String s = list.get(i);
                    str=s+",";
                }
                Log.i("qqq", "getStrng: "+str);
                String seat = str.substring(0, str.lastIndexOf(","));
                SharedPreferences qq = getSharedPreferences("zw", Context.MODE_PRIVATE);
                qq.edit().putString("seat",seat).commit();
            }
        });
    }

    @Override
    public void Pbrq(PbrqBean bean) {
        List<PbrqBean.ResultBean> result = bean.getResult();
        roomTime.setText("选择影厅和时间("+result.size()+")");
        PdrqAdapter pdrqAdapter=new PdrqAdapter(result,this);
        roomRecycler.setAdapter(pdrqAdapter);
        pdrqAdapter.setCallBack(new PdrqAdapter.iCallBack() {


            @Override
            public void getBack(String s) {

            }

            @Override
            public void getId(int idd) {
                int idd1 = idd;
                present.setl(idd1);
                String id = Integer.toString(idd);
                String s = ussid+id+"movie";
                Log.i("qqq", "onClick: "+idd);
                String sign = MD5(s);
                Log.i("qqq", "onClick: "+sign);
                radioWx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences qw = getSharedPreferences("zw", Context.MODE_PRIVATE);
                        String seat = qw.getString("seat", null);
                        if (radioWx.isChecked()){
                            SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
                            int ussid1 = jin.getInt("ussid", 0);
                            String ussisnid1 = jin.getString("ussisnid", "");

                            present.tickls(ussid1,ussisnid1,idd,seat,sign);
                        }
                    }
                });
            }
        });

    }

    @Override
    public void Succes(DetailsBean bean) {
        for (int i = 0; i <bean.getResult().getShortFilmList().size() ; i++) {
            roomVideoPlayer.setUp(bean.getResult().getShortFilmList().get(i).getVideoUrl(),"视频");
            Glide.with(this).load(bean.getResult().getShortFilmList().get(i).getImageUrl()).into(roomVideoPlayer.ivThumb);
        }

    }

    @Override
    public void TicketsSuce(TicketsBean bean) {
        orderId = bean.getOrderId();
       present.wxzfp(ussid,ussisnid, orderId);
    }

    @Override
    public void WxzfSucess(WxzfpriceBean bean) {
        PayReq payReq=new PayReq();
        payReq.appId =bean.getAppId();
        payReq.prepayId =bean.getPrepayId();
        payReq.partnerId =bean.getPartnerId();
        payReq.nonceStr=bean.getNonceStr();
        payReq.timeStamp =bean.getTimeStamp();
        payReq.packageValue =bean.getPackageValue();
        payReq.sign =bean.getSign();
       payReq.extData = "app data"; // optional
        MyApplication.api.sendReq(payReq);

    }


    //MD5加密
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
