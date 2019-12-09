package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.MovieTickBean;
import com.bw.movie.model.bean.QRcodeBean;
import com.bw.movie.present.MovieTickPresent;
import com.bw.movie.view.adapter.My_Movie_Adapter;
import com.facebook.drawee.view.SimpleDraweeView;

public class My_MovieActivity extends BeasActivity<MovieTickPresent> implements ICountView.MovieTickView {
    private RecyclerView recycler_view;
    private ImageView details_back;
    private SimpleDraweeView img_sipp;
    private TextView text_movie;
    private Button text_but;
    private int ussid;
    private String ussisnid;

    @Override
    protected int setLyout() {
        return R.layout.activity_my__movie;
    }

    @Override
    protected void inttView() {
        recycler_view=findViewById(R.id.recycler_view);
        details_back=findViewById(R.id.details_back);
        text_but=findViewById(R.id.text_but);
        text_movie=findViewById(R.id.text_movie);
        img_sipp=findViewById(R.id.img_sipp);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected MovieTickPresent Present() {
        return new MovieTickPresent();
    }

    @Override
    protected void inttData() {
        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
        present.movietick(ussid, ussisnid);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        text_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_but.setVisibility(View.GONE);
                text_movie.setVisibility(View.GONE);
                img_sipp.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void MovieTickSucess(MovieTickBean bean) {

        My_Movie_Adapter adapter=new My_Movie_Adapter(bean.getResult(),this);
        recycler_view.setAdapter(adapter);
        adapter.setOnCikedfbutteon(new My_Movie_Adapter.OnCikedfbutteon() {
            @Override
            public void OncikebuttSunsd(int id) {
              present.qrcode(ussid,ussisnid,id);
                img_sipp.setVisibility(View.VISIBLE);
                text_movie.setVisibility(View.VISIBLE);
                text_but.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void QRcodeSucess(QRcodeBean bean) {
        img_sipp.setImageURI(bean.getResult().getExchangeCode());
    }
}
