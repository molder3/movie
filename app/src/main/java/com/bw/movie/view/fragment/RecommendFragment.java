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
import com.bw.movie.model.RecommendBean;
import com.bw.movie.present.RecommendPresent;
import com.bw.movie.view.activity.CinemaActivity;
import com.bw.movie.view.adapter.RecommendAdapter;

/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class RecommendFragment extends BeasFragment<RecommendPresent> implements ICountView.RecoView {
    private RecyclerView two_recy;
    private int ussid;
    private String ussisnid;
    private RecommendAdapter adapter;
    private SharedPreferences cine;
    private SharedPreferences.Editor edit;
    @Override
    protected int setLyout() {
        return R.layout.recommend;
    }

    @Override
    protected void intiView() {
        two_recy=getViewId(R.id.two_recy);
        two_recy.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    protected RecommendPresent setPrsent() {
        return new RecommendPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin = getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
        SharedPreferences jingw = getActivity().getSharedPreferences("jingw", Context.MODE_PRIVATE);
        String longitude = jingw.getString("longitude", "");
        String latitude = jingw.getString("latitude", "");

        fpresen.recomm(ussid, ussisnid, longitude, latitude);
        cine = getActivity().getSharedPreferences("cine", Context.MODE_PRIVATE);
        edit = cine.edit();
    }

    @Override
    public void Sucees(RecommendBean bean) {
        adapter = new RecommendAdapter(bean.getResult(),getActivity());
        two_recy.setAdapter(adapter);
        adapter.setmOnItemClickListenerid(new RecommendAdapter.OnItemClickListener() {
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
}
