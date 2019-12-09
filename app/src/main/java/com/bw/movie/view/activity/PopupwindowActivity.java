package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.ByPriceBean;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.bean.TimeBean;
import com.bw.movie.present.DetailsPresent;
import com.bw.movie.present.xuandetails.XuanDetailsPresent;
import com.bw.movie.view.adapter.ByPriceAdapter;
import com.bw.movie.view.adapter.NearbyAdapter;
import com.bw.movie.view.adapter.QuyuAdapter;
import com.bw.movie.view.adapter.QuyutwoAdapter;
import com.bw.movie.view.adapter.TimeAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class PopupwindowActivity extends BeasActivity<XuanDetailsPresent> implements ICountView.DetalisView {

    private JCVideoPlayer popu_jc;
    private TextView popu_time,popu_ping,popu_dao,popw_name,popu_diqu,popu_riqi,jiazui;
    private Context context;
    private PopupWindow popup,popup1;
    private QuyutwoAdapter adapter;
    RecyclerView recyclerView,recyclerView1,recyclerView2;
    private RecyclerView popu_xrecy;
    private TimeAdapter timeAdapter;
    private String s1;
    private NearbyAdapter nearbyAdapter;
    private ByPriceAdapter byPriceAdapter;

    @Override
    protected int setLyout() {
        return R.layout.activity_popupwindow;
    }

    @Override
    protected void inttView() {
        popu_dao=findViewById(R.id.popu_dao);
        popu_ping=findViewById(R.id.popu_ping);
        popu_time=findViewById(R.id.popu_time);
        popu_jc=findViewById(R.id.popu_jc);
        popw_name=findViewById(R.id.popw_name);
        popu_diqu=findViewById(R.id.popu_diqu);
        popu_riqi=findViewById(R.id.popu_riqi);
        popu_xrecy=findViewById(R.id.popu_xrecy);
        jiazui=findViewById(R.id.jiazui);
        popu_xrecy.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected XuanDetailsPresent Present() {
        return new XuanDetailsPresent();
    }

    @Override
    protected void inttData() {
        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
       /* SharedPreferences moview = getSharedPreferences("moview", Context.MODE_PRIVATE);
        int movieId = moview.getInt("movieId", 0);*/
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movie", 0);
        present.detalisview(ussid, ussisnid, movieId);
        present.fjinview();
        present.tiemi();
        present.byprice(movieId);
    }

    @Override
    public void Succes(DetailsBean bean) {
        for (int i = 0; i <bean.getResult().getShortFilmList().size() ; i++) {
            popu_jc.setUp(bean.getResult().getShortFilmList().get(i).getVideoUrl(),"视频");
           Glide.with(this).load(bean.getResult().getShortFilmList().get(i).getImageUrl()).into(popu_jc.ivThumb);
        }
          popw_name.setText(bean.getResult().getName());

            popu_dao.setText(bean.getResult().getMovieDirector().get(0).getName());

       popu_ping.setText(bean.getResult().getScore()+"分");
       popu_time.setText(bean.getResult().getDuration());

    }

    @Override
    public void Suvess(QuyuBean bean) {

 adapter=new QuyutwoAdapter(bean.getResult(),this);

        popu_diqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View inflate = getLayoutInflater().inflate(R.layout.popu, null);
                inflate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popup.dismiss();
                    }
                });
                popup=new PopupWindow(inflate, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                popup.setFocusable(true);
                popup.showAsDropDown(popu_diqu,60,0);
               recyclerView = inflate.findViewById(R.id.po_recy);
               recyclerView.setLayoutManager(new LinearLayoutManager(context));

               recyclerView.setAdapter(adapter);
                adapter.onItemClickListenered(new QuyutwoAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClickkk(String regionName) {
                        popu_diqu.setText(regionName);
                        popup.dismiss();
                    }
                });

            }
        });
    }

    @Override
    public void TimeSuess(TimeBean bean) {
        List<String> result = bean.getResult();
        timeAdapter = new TimeAdapter( result,this);
          popu_riqi.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  View inflate = getLayoutInflater().inflate(R.layout.popu1, null);
                  inflate.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          popup1.dismiss();
                      }
                  });
                  popup1=new PopupWindow(inflate,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
                  popup1.setFocusable(true);

                  popup1.showAsDropDown(popu_diqu, 250,0);
                  recyclerView1 = inflate.findViewById(R.id.po1_recy);
                  recyclerView2 = inflate.findViewById(R.id.popu_recy);
                  recyclerView1.setLayoutManager(new LinearLayoutManager(context));
                  recyclerView2.setLayoutManager(new LinearLayoutManager(context));
                  recyclerView1.setAdapter(timeAdapter);
              timeAdapter.setOnIntimeOcilek(new TimeAdapter.OnIntimeOcilek() {

                  @Override
                  public void OnTimeOcked(String s) {
                      s1 = s;
                      popu_riqi.setText(s);
                      popup1.dismiss();
                  }
              });

              }
          });

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("今日MM-dd");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        popu_riqi.setText(simpleDateFormat.format(date));

    }

    @Override
    public void BypriceSuess(ByPriceBean bean) {
        byPriceAdapter = new ByPriceAdapter(bean.getResult(),this);
        jiazui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popu_xrecy.setAdapter(byPriceAdapter);
            }
        });
        byPriceAdapter.setOnInnerabyOcilek(new ByPriceAdapter.OnInnerabyOcilek() {
            @Override
            public void OnnerbayOcked(int id) {
                Intent intent=new Intent(PopupwindowActivity.this,RommxuazActivity.class);
                intent.putExtra("hllid",id);
                startActivity(intent);
            }
        });
    }

  /*  @Override
    public void NeberSuess(NearbyBean bean) {
        nearbyAdapter = new NearbyAdapter(bean.getResult(),this);
        popu_xrecy.setAdapter(nearbyAdapter);
        nearbyAdapter.setOnInnerabyOcilek(new NearbyAdapter.OnInnerabyOcilek() {
            @Override
            public void OnnerbayOcked(int id) {
                 Intent intent=new Intent(PopupwindowActivity.this,RommxuazActivity.class);
                intent.putExtra("hllid",id);
                startActivity(intent);
            }
        });
    }
*/

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
