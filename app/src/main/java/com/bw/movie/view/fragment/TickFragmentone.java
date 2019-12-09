package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.TickBean;
import com.bw.movie.present.TickPrsent;
import com.bw.movie.view.adapter.TickoneAdapter;

import java.util.List;

/**
 * date:2019/12/3
 * author:金豪(Lenovo)
 * function:
 */
public class TickFragmentone extends BeasFragment<TickPrsent> implements ICountView.TickView {
    private RecyclerView cinema_recycler;
    private RelativeLayout lin_visi;
    @Override
    protected int setLyout() {
        return R.layout.tickone;
    }

    @Override
    protected void intiView() {
        lin_visi=getViewId(R.id.lin_visi);
        cinema_recycler=getViewId(R.id.cinema_recycler);
        cinema_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected TickPrsent setPrsent() {
        return new TickPrsent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin =getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
        fpresen.tickd(ussid,ussisnid,1);

    }

    @Override
    public void TickSucess(TickBean bean) {
        List<TickBean.ResultBean> result = bean.getResult();
        if (result != null) {
            cinema_recycler.setVisibility(View.VISIBLE);
            lin_visi.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
            cinema_recycler.setLayoutManager(linearLayoutManager);
            TickoneAdapter adapter=new TickoneAdapter(bean.getResult(),getActivity());
            cinema_recycler.setAdapter(adapter);
        } else {
            cinema_recycler.setVisibility(View.GONE);
            lin_visi.setVisibility(View.VISIBLE);
        }

    }
}
