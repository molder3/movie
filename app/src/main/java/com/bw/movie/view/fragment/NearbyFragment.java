package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.NearbyBean;
import com.bw.movie.present.NearbyPresent;
import com.bw.movie.view.activity.CinemaActivity;
import com.bw.movie.view.adapter.NearbyAdapter;

/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class NearbyFragment extends BeasFragment<NearbyPresent> implements ICountView.NearbyView {
    private RecyclerView myone_recy;
    private NearbyAdapter adapter;
    private SharedPreferences cine;
    private SharedPreferences.Editor edit;
    @Override
    protected int setLyout() {
        return R.layout.nearby;
    }

    @Override
    protected void intiView() {
        myone_recy=getViewId(R.id.myone_recy);
        myone_recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    protected NearbyPresent setPrsent() {
        return new NearbyPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin =getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");

        fpresen.nearby(ussid, ussisnid);
        cine = getActivity().getSharedPreferences("cine", Context.MODE_PRIVATE);
        edit = cine.edit();
    }

    @Override
    public void Sucess(NearbyBean bean) {
        adapter = new NearbyAdapter(bean.getResult(),getActivity());
        myone_recy.setAdapter(adapter);
        adapter.setOnInnerabyOcilek(new NearbyAdapter.OnInnerabyOcilek() {
            @Override
            public void OnnerbayOcked(int id) {
                Intent intent=new Intent(getActivity(), CinemaActivity.class);
                intent.putExtra("id", id);
                edit.putInt("cinemaId",id);
                edit.commit();
                startActivity(intent);
            }
        });
    }
}
