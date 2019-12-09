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
import com.bw.movie.model.bean.ReserveBean;
import com.bw.movie.present.ReserPresent;
import com.bw.movie.view.adapter.ReserveAdapter;

public class ResertActivity extends BeasActivity<ReserPresent> implements ICountView.ReserveView {
       private RecyclerView recd_recy;
         private ImageView details_back;

    @Override
    protected int setLyout() {
        return R.layout.activity_resert;
    }

    @Override
    protected void inttView() {
        recd_recy=findViewById(R.id.recd_recy);
        details_back=findViewById(R.id.details_back);
        recd_recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected ReserPresent Present() {
        return new ReserPresent();
    }

    @Override
    protected void inttData() {
        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
       present.cinelike(ussid,ussisnid);
       details_back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });
    }

    @Override
    public void ReserveSucess(ReserveBean bean) {
        ReserveAdapter adapter=new ReserveAdapter(bean.getResult(),this);
        recd_recy.setAdapter(adapter);
    }
}
