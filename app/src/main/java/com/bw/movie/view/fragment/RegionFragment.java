package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.QuyuBean;
import com.bw.movie.model.bean.RegionBean;
import com.bw.movie.present.LikePresent;
import com.bw.movie.view.activity.CinemaActivity;
import com.bw.movie.view.adapter.QuyuAdapter;
import com.bw.movie.view.adapter.RegionAdapter;

/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class RegionFragment extends BeasFragment<LikePresent>  implements ICountView.LikeView {
    private RecyclerView cf_cy, cf_recy;
    private QuyuAdapter adapter1;
    private RegionAdapter reginAdapter;
    private SharedPreferences cine;
    private SharedPreferences.Editor edit;


    @Override
    protected int setLyout() {
        return R.layout.region;
    }

    @Override
    protected void intiView() {
        cf_cy = getViewId(R.id.cf_cy);
        cf_recy = getViewId(R.id.cf_recy);

        cf_cy.setLayoutManager(new LinearLayoutManager(getActivity()));
        cf_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
        cine = getActivity().getSharedPreferences("cine", Context.MODE_PRIVATE);
        edit = cine.edit();
    }

    @Override
    protected LikePresent setPrsent() {
        return new LikePresent();
    }

    @Override
    protected void intiData() {
        fpresen.fjin();
    }

    @Override
    public void Suess(RegionBean bean) {
        reginAdapter = new RegionAdapter(bean.getResult(),getActivity());
        cf_recy.setAdapter(reginAdapter);
        reginAdapter.setmOnItemClickListenerid(new RegionAdapter.OnItemClickListener() {
            @Override
            public void onItemClickid(int id) {
                Intent intent=new Intent(getActivity(), CinemaActivity.class);
                intent.putExtra("id", id);
                edit.putInt("cinemaId",id);
                edit.commit();
                startActivity(intent);
            }
        });
    }

    @Override
    public void Suess(QuyuBean bean) {
        adapter1 = new QuyuAdapter(bean.getResult(),getActivity());
        cf_cy.setAdapter(adapter1);
        adapter1.onItemClickListener(new QuyuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int regionId) {
                fpresen.like(regionId);
            }
        });
    }
}
