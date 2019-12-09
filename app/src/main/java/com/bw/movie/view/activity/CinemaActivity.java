package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.GuanzhucineBean;
import com.bw.movie.model.bean.QuxiaoguanzBean;
import com.bw.movie.present.CinemaPresent;
import com.bw.movie.view.adapter.CominAdapter;
import com.bw.movie.view.fragment.CinemaFragementont;
import com.bw.movie.view.fragment.CinemaFragementtwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class CinemaActivity extends BeasActivity<CinemaPresent> implements ICountView.CinemaView{

    private CheckBox hong;
    private ViewPager vp;
    private RadioGroup raDy;
    private TextView textD,textif;
    private CinemaFragementont cinemaFragementont;
    private CinemaFragementtwo cinemaFragementtwo;
    private List<Fragment> list;
    private ImageView cineimg;
    private Button but_dypq;
    private int ussid;
    private String ussisnid;
    private int id;

    @Override
    protected int setLyout() {
        return R.layout.activity_cinema;
    }

    @Override
    protected void inttView() {
        vp=findViewById(R.id.vp);
        raDy=findViewById(R.id.rg_dy);
        textD=findViewById(R.id.text_D);
        textif=findViewById(R.id.text_if);
        cineimg=findViewById(R.id.details_back);
        but_dypq=findViewById(R.id.but_dypq);
        hong=findViewById(R.id.hong);
    }

    @Override
    protected CinemaPresent Present() {
        return new CinemaPresent();
    }

    @Override
    protected void inttData() {
        SharedPreferences jin = getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
        id = getIntent().getIntExtra("id", 0);

        present.cinema(ussid, ussisnid, id);
        cinemaFragementont = new CinemaFragementont();
        cinemaFragementtwo = new CinemaFragementtwo();
        list = new ArrayList<>();
        list.add(cinemaFragementont);
        list.add(cinemaFragementtwo);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        raDy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.but_yyxq:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.but_yypj:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });
        hong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    present.guanzhu(ussid, ussisnid, id);
                    hong.setButtonDrawable(R.mipmap.heixin);
                }else {
                    present.quxiaoguanzhu(ussid, ussisnid, id);
                    hong.setButtonDrawable(R.mipmap.hongxin);
                }
            }
        });
        cineimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              CinemaActivity.this.finish();
            }
        });
        but_dypq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CinemaActivity.this,ScheduleActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void Sucees(CinemaBean bean) {

          textif.setText(bean.getResult().getName());
          textD.setText(bean.getResult().getLabel());
    }

    @Override
    public void GuasnzhuSuces(GuanzhucineBean bean) {
        if (bean!=null){
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void QuxiaoSucess(QuxiaoguanzBean bean) {
        if (bean!=null){
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
