package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.SystemBean;
import com.bw.movie.present.SystemPresent;

public class SystemActivity extends BeasActivity<SystemPresent> implements ICountView.SystemView{

    private RecyclerView syst_recy;
    @Override
    protected int setLyout() {
        return R.layout.activity_system;
    }

    @Override
    protected void inttView() {
        syst_recy=findViewById(R.id.syst_recy);
        syst_recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected SystemPresent Present() {
        return new SystemPresent();
    }

    @Override
    protected void inttData() {

    }

    @Override
    public void SystemSuces(SystemBean bean) {

    }
}
