package com.bw.movie.view.fragment.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.MovieLikeBean;
import com.bw.movie.model.bean.MovieNoLikeBean;
import com.bw.movie.present.DetailsPresent;
import com.bw.movie.view.adapter.ActorAdapter;
import com.bw.movie.view.adapter.DirectorAdapter;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class IntroduceFragment extends BeasFragment<DetailsPresent> implements ICountView.Detalis{
    private TextView interdoce_jie;
    private RecyclerView interdoce_recyle;
    private DirectorAdapter adapter;
    private RecyclerView interdoce_actor;
    private ActorAdapter actorAdapter;
    @Override
    protected int setLyout() {
        return R.layout.introduce;
    }

    @Override
    protected void intiView() {
        interdoce_jie=getViewId(R.id.interdoce_jie);
        interdoce_recyle=getViewId(R.id.interdoce_recyle);
        interdoce_actor=getViewId(R.id.interdoce_actor);
        interdoce_recyle.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        interdoce_actor.setLayoutManager(new GridLayoutManager(getActivity(),4));
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
        interdoce_jie.setText(bean.getResult().getSummary());
        adapter = new DirectorAdapter(bean.getResult().getMovieDirector(),getActivity());
        interdoce_recyle.setAdapter(adapter);
        //演员
        actorAdapter = new ActorAdapter(bean.getResult().getMovieActor(),getActivity());
        interdoce_actor.setAdapter(actorAdapter);
    }

    @Override
    public void MovieLikeSucess(MovieLikeBean bean) {

    }

    @Override
    public void MovieNolieSunse(MovieNoLikeBean bean) {

    }
}
