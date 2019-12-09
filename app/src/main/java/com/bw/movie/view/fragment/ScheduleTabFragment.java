package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.PaiqiBean;
import com.bw.movie.present.PaiDriPreset;
import com.bw.movie.view.activity.MoviedetailsActivity;
import com.bw.movie.view.adapter.PaidangriqiAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * date:2019/11/30
 * author:金豪(Lenovo)
 * function:
 */
public class ScheduleTabFragment extends BeasFragment<PaiDriPreset> implements ICountView.PdrqinView {
    private RecyclerView xlist_view;
    int page = 1;
    private int did;
    @Override
    protected int setLyout() {
        return R.layout.schedule;
    }

    @Override
    protected void intiView() {
        xlist_view=getViewId(R.id.xlist_view);

    }

    @Override
    protected PaiDriPreset setPrsent() {
        return new PaiDriPreset();
    }

    @Override
    protected void intiData() {
        SharedPreferences cine = getActivity().getSharedPreferences("cine", Context.MODE_PRIVATE);
        did = cine.getInt("cinemaId", 0);
        fpresen.pdrqd(did);
    }


    @Override
    public void PdriSuess(PaiqiBean bean) {
        PaidangriqiAdapter adapter=new PaidangriqiAdapter(bean.getResult(),getActivity());
        xlist_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        xlist_view.setAdapter(adapter);
        adapter.setItemClickListener(new PaidangriqiAdapter.ItemClickListener() {
            @Override
            public void ItemClickListener(int movieid, String imageUrl) {
                Intent intent = new Intent(getActivity(), MoviedetailsActivity.class);
                intent.putExtra("movieId",movieid);

                startActivity(intent);
            }
        });
    }
}
