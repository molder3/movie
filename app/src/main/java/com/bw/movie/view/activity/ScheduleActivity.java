package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.ByPriceBean;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.bean.TimeBean;
import com.bw.movie.present.xuandetails.XuanDetailsPresent;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ScheduleActivity extends BeasActivity<XuanDetailsPresent> implements ICountView.DetalisView{
   private ImageView details_back;
   private TabLayout tab_lay;
   private ViewPager view_pager;
    private int did;
    @Override
    protected int setLyout() {
        return R.layout.activity_schedule;
    }

    @Override
    protected void inttView() {
        details_back=findViewById(R.id.details_back);
        tab_lay=findViewById(R.id.tab_lay);
        view_pager=findViewById(R.id.view_pager);

    }

    @Override
    protected XuanDetailsPresent Present() {
        return new XuanDetailsPresent();
    }

    @Override
    protected void inttData() {
       present.tiemi();
       details_back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ScheduleActivity.this.finish();
           }
       });
        Intent intent = getIntent();
        did = intent.getIntExtra("did", 0);
    }

    @Override
    public void Succes(DetailsBean bean) {

    }

    @Override
    public void Suvess(QuyuBean bean) {

    }

    @Override
    public void TimeSuess(TimeBean bean) {
        List<String> result = bean.getResult();
        for (int i = 0; i < result.size(); i++) {
            final String s = result.get(i);
            TabLayout.Tab tab = tab_lay.newTab();
            if (tab != null) {
                tab.setText(s);
                tab_lay.addTab(tab);
            }
        }
        ScheduleTabAdapter scheduleTabAdapter = new ScheduleTabAdapter(getSupportFragmentManager(),result,did);
        tab_lay.setupWithViewPager(view_pager);
        view_pager.setAdapter(scheduleTabAdapter);
    }

    @Override
    public void BypriceSuess(ByPriceBean bean) {

    }
}
