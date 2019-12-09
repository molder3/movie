package com.bw.movie.view.fragment.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.WeisheBean;
import com.bw.movie.present.WeishenPresent;
import com.bw.movie.view.adapter.WeishenAdapter;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class YingpingFragment extends BeasFragment<WeishenPresent> implements ICountView.WeiView {
    private RecyclerView yingp_recy;
    private WeishenAdapter adapter;

    @Override
    protected int setLyout() {
        return R.layout.yingping;
    }

    @Override
    protected void intiView() {
        yingp_recy=getViewId(R.id.yingp_recy);
        yingp_recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    protected WeishenPresent setPrsent() {
        return new WeishenPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin =getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        fpresen.weishe(ussid,ussisnid,movieId);
    }

    @Override
    public void Sucess(WeisheBean bean) {
        adapter = new WeishenAdapter(bean.getResult(),getActivity());
       yingp_recy.setAdapter(adapter);
    }
}
