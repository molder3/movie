package com.bw.movie.view.activity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.MovieLikeBean;
import com.bw.movie.model.bean.MovieNoLikeBean;
import com.bw.movie.present.DetailsPresent;
import com.bw.movie.view.fragment.moviedetails.AdvanceFragment;
import com.bw.movie.view.fragment.moviedetails.IntroduceFragment;
import com.bw.movie.view.fragment.moviedetails.JuzhaoFragment;
import com.bw.movie.view.fragment.moviedetails.YingpingFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MoviedetailsActivity extends BeasActivity<DetailsPresent> implements ICountView.Detalis {
    private SimpleDraweeView details_img;
    private ImageView details_like,details_nolike;
    private TextView details_name,details_guanz,details_quxiao,details_type,details_time,details_riqi
            ,details_place,details_score,details_comme;
    private TabLayout details_tab;
    private CustomScrollViewPager details_viewp;
    private List<String> mTlist;
    private List<Fragment> mFlist;
    private Button xiepingl,xuanz;
    private int movieId;
    private SharedPreferences hao;
    private SharedPreferences.Editor edit;
    private int movieId1;
    private String ussisnid;
    private int ussid;


    @Override
    protected int setLyout() {
        return R.layout.activity_moviedetails;
    }

    @Override
    protected void inttView() {
        //获取id
        details_img = findViewById(R.id.details_img);
        details_name = findViewById(R.id.details_name);
        details_nolike = findViewById(R.id.details_nolike);
        details_like = findViewById(R.id.details_like);
        details_guanz = findViewById(R.id.details_guanz);
        details_quxiao = findViewById(R.id.details_quxiao);
       // details_type = findViewById(R.id.details_type);
        //details_time = findViewById(R.id.details_time);
        details_riqi = findViewById(R.id.details_riqi);
        details_place = findViewById(R.id.details_place);
       details_score = findViewById(R.id.details_score);
       details_comme = findViewById(R.id.details_comme);
        details_tab = findViewById(R.id.details_tab);
        details_viewp = findViewById(R.id.details_viewp);
        xiepingl = findViewById(R.id.xiepingl);
        xuanz = findViewById(R.id.xuanz);
        hao = getSharedPreferences("hao", Context.MODE_PRIVATE);
        edit = hao.edit();
    }

    @Override
    protected DetailsPresent Present() {
        return new DetailsPresent();
    }

    @Override
    protected void inttData() {
        SharedPreferences jin = getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
       /* SharedPreferences moview = getSharedPreferences("moview", Context.MODE_PRIVATE);
        int movieId = moview.getInt("movieId", 0);*/
        Intent intent = getIntent();
        movieId1 = intent.getIntExtra("movieId", 0);
        present.detalis(ussid, ussisnid, movieId1);
        //显示和隐藏
        details_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                present.movielike(ussid,ussisnid,movieId1);
                details_like.setVisibility(View.INVISIBLE);
                details_nolike.setVisibility(View.VISIBLE);
                details_guanz.setVisibility(View.INVISIBLE);
                details_quxiao.setVisibility(View.VISIBLE);

            }
        });
        details_nolike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                present.nomovielike(ussid,ussisnid,movieId1);
                details_like.setVisibility(View.VISIBLE);
                details_nolike.setVisibility(View.INVISIBLE);
                details_guanz.setVisibility(View.VISIBLE);
                details_quxiao.setVisibility(View.INVISIBLE);
                Toast.makeText(MoviedetailsActivity.this, "取消关注成功", Toast.LENGTH_SHORT).show();
            }
        });
        //TabLayout
        mTlist=new ArrayList<>();
        mTlist.add("介绍");
        mTlist.add("预告");
        mTlist.add("剧照");
        mTlist.add("影评");
        mFlist=new ArrayList<>();
        mFlist.add(new IntroduceFragment());
        mFlist.add(new AdvanceFragment());
        mFlist.add(new JuzhaoFragment());
        mFlist.add(new YingpingFragment());
        details_viewp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFlist.get(i);
            }

            @Override
            public int getCount() {
                return mFlist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTlist.get(position);
            }
        });
        details_tab.setupWithViewPager(details_viewp);

        //写评论
        xiepingl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MoviedetailsActivity.this, WriteCommActivity.class);
                intent1.putExtra("movie", movieId1);
                edit.putInt("movieid", movieId1);
                edit.commit();
                startActivity(intent1);
            }
        });
        xuanz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MoviedetailsActivity.this,PopupwindowActivity.class);
                intent1.putExtra("movie", movieId1);
                edit.putInt("movieid", movieId1);
                edit.commit();
                startActivity(intent1);
            }
        });

    }

    @Override
    public void Succes(final DetailsBean bean) {
        movieId = bean.getResult().getMovieId();
        details_img.setImageURI(bean.getResult().getImageUrl());
       // Glide.with(this).load(bean.getResult().getImageUrl()).into(details_img);
      /*  xuanz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(ShouActivity.this,RommActivity.class);
                intent3.putExtra("name",bean.getResult().getName());
                intent3.putExtra("imageUrl",bean.getResult().getImageUrl());
                intent3.putExtra("movie",bean.getResult().getMovieId());
                startActivity(intent3);
            }
        });*/
        details_name.setText(bean.getResult().getName());
       // details_time.setText(bean.getResult().getDuration());
      //  details_type.setText(bean.getResult().getMovieType());
        details_place.setText(bean.getResult().getPlaceOrigin());
        long releaseTime = bean.getResult().getReleaseTime();
        SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
        String format = simple.format(releaseTime);
        details_riqi.setText(format);
       details_comme.setText("评论"+bean.getResult().getCommentNum()+"万条");
      details_score.setText("评分"+bean.getResult().getScore()+"分");

    }

    @Override
    public void MovieLikeSucess(MovieLikeBean bean) {
            if (bean!=null){
                Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void MovieNolieSunse(MovieNoLikeBean bean) {

    }


}
