package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.request.transition.Transition;
import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.view.adapter.ViewAdapter;
import com.bw.movie.view.fragment.CominFragement;
import com.bw.movie.view.fragment.MovieFragment;
import com.bw.movie.view.fragment.MovieFragment1;
import com.bw.movie.view.fragment.MyFragement;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BeasActivity implements View.OnClickListener {



    private ImageView imageMoveiDj,imageCinemDj,imageMyyDj;
    private LinearLayout linMovei,linCinem,linMyy,layOne,layTwo,laySwe;
    private CustomScrollViewPager viewPager;
    List<Fragment> list = new ArrayList<>();
    List<LinearLayout> llist = new ArrayList<>();
    @Override
    protected int setLyout() {
        return R.layout.activity_home;
    }

    @Override
    protected void inttView() {
        layOne=findViewById(R.id.lay_one);
        layTwo=findViewById(R.id.lay_two);
        laySwe=findViewById(R.id.lay_swe);
        linMovei=findViewById(R.id.lin_movei);
        linCinem=findViewById(R.id.lin_cinem);
        linMyy=findViewById(R.id.lin_myy);
        imageMoveiDj=findViewById(R.id.image_movei_dj);
        imageCinemDj=findViewById(R.id.image_cinem_dj);
        imageMyyDj=findViewById(R.id.image_myy_dj);
        viewPager=findViewById(R.id.sh_view);

    }

    @Override
    protected BeasPresent Present() {
        return new BeasPresent();
    }

    @Override
    protected void inttData() {
        list.add(new MovieFragment());
        list.add(new MyFragement());
        list.add(new CominFragement());
        llist.add(linMovei);
        llist.add(linCinem);
        llist.add(linMyy);
        viewPager.setScrollable(false);
        ViewAdapter viewAdapter = new ViewAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(viewAdapter);
        imageMoveiDj.setOnClickListener(this);
        imageCinemDj.setOnClickListener(this);
        imageMyyDj.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_movei_dj:
                imageMoveiDj.setVisibility(View.GONE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.VISIBLE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.GONE);
                viewPager.setCurrentItem(0);
                break;
            case R.id.image_cinem_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.GONE);
                imageMyyDj.setVisibility(View.VISIBLE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.VISIBLE);
                linMyy.setVisibility(View.GONE);
                viewPager.setCurrentItem(1);
                break;
            case R.id.image_myy_dj:
                imageMoveiDj.setVisibility(View.VISIBLE);
                imageCinemDj.setVisibility(View.VISIBLE);
                imageMyyDj.setVisibility(View.GONE);
                linMovei.setVisibility(View.GONE);
                linCinem.setVisibility(View.GONE);
                linMyy.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(2);
                break;
        }

    }
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                System.exit(0);
            } else {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
