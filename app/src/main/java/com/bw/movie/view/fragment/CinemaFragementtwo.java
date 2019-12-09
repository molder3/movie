package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinePinglunBean;
import com.bw.movie.model.bean.WeisheBean;
import com.bw.movie.present.CinepingPresent;
import com.bw.movie.present.WeishenPresent;
import com.bw.movie.view.adapter.CinePinAdapter;

/**
 * date:2019/11/14
 * author:金豪(Lenovo)
 * function:
 */
public class CinemaFragementtwo extends BeasFragment<CinepingPresent> implements ICountView.CinePingView {
   private RecyclerView cine_rece;
    @Override
    protected int setLyout() {
        return R.layout.cinemafragmenttwo;
    }

    @Override
    protected void intiView() {
        cine_rece=getViewId(R.id.cine_rece);
        cine_rece.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected CinepingPresent setPrsent() {
        return new CinepingPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin = getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
        SharedPreferences cine = getActivity().getSharedPreferences("cine", Context.MODE_PRIVATE);
        int cinemaId = cine.getInt("cinemaId", 0);
        fpresen.coinep(ussid,ussisnid,cinemaId);
    }


    @Override
    public void PingSucess(CinePinglunBean bean) {
        CinePinAdapter adapter=new CinePinAdapter(bean.getResult(),getActivity());
        cine_rece.setAdapter(adapter);
    }
}
