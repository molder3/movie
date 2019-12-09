package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.XflimBean;
import com.bw.movie.present.XfilmPresent;
import com.bw.movie.view.activity.MainActivity;
import com.bw.movie.view.activity.loginregister.LoginActivity;

public class WriteCommActivity extends BeasActivity<XfilmPresent> implements ICountView.XfilmView {
    private ImageView ra_img;
    private TextView ra_name,ra_ping;
    private RatingBar ra_ratingba;
    private EditText ra_ed;
    private Button ra_but;
    private Double s;
    private int ussid;
    private String ussisnid;
    private int movieId;
    private double score;
    private double progress;
    @Override
    protected int setLyout() {
        return R.layout.activity_write_comm;
    }

    @Override
    protected void inttView() {
        ra_but=findViewById(R.id.ra_but);
        ra_ed=findViewById(R.id.ra_ed);
        ra_ratingba=findViewById(R.id.ra_ratingba);
        ra_name=findViewById(R.id.ra_name);
        ra_ping=findViewById(R.id.ra_ping);
        ra_img=findViewById(R.id.ra_img);
    }

    @Override
    protected XfilmPresent Present() {
        return new XfilmPresent();
    }

    @Override
    protected void inttData() {

        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
       /* SharedPreferences moview = getSharedPreferences("moview", Context.MODE_PRIVATE);
        int movieId = moview.getInt("movieId", 0);*/
        Intent intent = getIntent();
        int moviei = intent.getIntExtra("movie", 0);
        ra_but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              String  trim = ra_ed.getText().toString().trim();
                String s = ra_ping.getText().toString();
                present.xfilm(ussid,ussisnid,moviei,trim, progress);
            }
        });
        ra_ratingba.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                progress = ratingBar.getProgress();
                ra_ping.setText("我的评分"+"("+rating+")"+"分");
            }
        });
    }

    @Override
    public void Sucess(XflimBean bean) {
        if (bean!=null){
            Toast.makeText(this,bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())){


             /*   Intent intent=new Intent(WriteCommActivity.this, MainActivity.class);
            startActivity(intent);*/
            }
        }
    }
}
