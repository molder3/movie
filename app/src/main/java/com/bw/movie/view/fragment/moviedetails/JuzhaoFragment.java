package com.bw.movie.view.fragment.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.MovieLikeBean;
import com.bw.movie.model.bean.MovieNoLikeBean;
import com.bw.movie.present.DetailsPresent;
import com.bw.movie.view.adapter.JuzhaoAdapter;

import java.util.List;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class JuzhaoFragment extends BeasFragment<DetailsPresent> implements ICountView.Detalis{


    private RecyclerView juzhao_recy;
    @Override
    protected int setLyout() {
        return R.layout.juzhao ;
    }

    @Override
    protected void intiView() {
        juzhao_recy=getViewId(R.id.juzhao_recy);
        juzhao_recy.setLayoutManager(new GridLayoutManager(getActivity(),4));
    }

    @Override
    protected DetailsPresent setPrsent() {
        return new DetailsPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin =getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
       /* SharedPreferences moview = getSharedPreferences("moview", Context.MODE_PRIVATE);
        int movieId = moview.getInt("movieId", 0);*/
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        fpresen.detalis(ussid, ussisnid, movieId);
    }

    @Override
    public void Succes(DetailsBean bean) {
        List<String> posterList = bean.getResult().getPosterList();
        JuzhaoAdapter adapter=new JuzhaoAdapter(posterList,getActivity());
        juzhao_recy.setAdapter(adapter);
    }

    @Override
    public void MovieLikeSucess(MovieLikeBean bean) {

    }

    @Override
    public void MovieNolieSunse(MovieNoLikeBean bean) {

    }
}
