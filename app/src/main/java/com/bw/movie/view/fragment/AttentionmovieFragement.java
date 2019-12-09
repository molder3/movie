package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.MovieLikegzBean;
import com.bw.movie.present.MovieLikegzPresent;
import com.bw.movie.view.adapter.GuanzhuAdaoter;

/**
 * date:2019/12/1
 * author:金豪(Lenovo)
 * function:
 */
public class AttentionmovieFragement extends BeasFragment<MovieLikegzPresent> implements ICountView.MoviLikeView {
    private RecyclerView guanzhu_recy;
    @Override
    protected int setLyout() {
        return R.layout.attentionmvie;
    }

    @Override
    protected void intiView() {
        guanzhu_recy=getViewId(R.id.guanzhu_recy);
        guanzhu_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected MovieLikegzPresent setPrsent() {
        return new MovieLikegzPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin = getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
        fpresen.guanzhu(ussid,ussisnid);
    }

    @Override
    public void MovielikeSUcess(MovieLikegzBean bean) {
        GuanzhuAdaoter adaoter=new GuanzhuAdaoter(bean.getResult(),getActivity());
        guanzhu_recy.setAdapter(adaoter);
    }
}
