package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.KanguoMovieBean;
import com.bw.movie.present.KanGuoPresent;
import com.bw.movie.view.adapter.KanGuoAdapter;

public class KanguoActivity extends BeasActivity<KanGuoPresent> implements ICountView.KanguoView {
     private RecyclerView kan_recty;
     private ImageView details_back;
    @Override
    protected int setLyout() {
        return R.layout.activity_kanguo;
    }

    @Override
    protected void inttView() {
        kan_recty=findViewById(R.id.kan_recty);
        details_back=findViewById(R.id.details_back);
        kan_recty.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected KanGuoPresent Present() {
        return new KanGuoPresent();
    }

    @Override
    protected void inttData() {
        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
       present.kanguo(ussid,ussisnid);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void KanguoSuness(KanguoMovieBean bean) {
        KanGuoAdapter adapter=new KanGuoAdapter(bean.getResult(),this);
        kan_recty.setAdapter(adapter);
    }
}
