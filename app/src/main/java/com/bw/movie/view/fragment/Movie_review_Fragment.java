package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.MoviePingLunBean;
import com.bw.movie.present.MoviePingPresent;
import com.bw.movie.view.adapter.Movie_review_Adapter;

import java.util.List;

/**
 * date:2019/12/4
 * author:金豪(Lenovo)
 * function:
 */
public class Movie_review_Fragment extends BeasFragment<MoviePingPresent> implements ICountView.MovieCiView {
     private RecyclerView erxfe;
    @Override
    protected int setLyout() {
        return R.layout.cinema_review_fragment;
    }

    @Override
    protected void intiView() {
        erxfe=getViewId(R.id.erxfe);
        erxfe.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected MoviePingPresent setPrsent() {
        return new MoviePingPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin =getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
        fpresen.moviep(ussid,ussisnid);
    }

    @Override
    public void MviwegSuess(MoviePingLunBean bean) {
        List<MoviePingLunBean.ResultBean> status = bean.getResult();
        if (status!=null){
            Movie_review_Adapter adapter=new Movie_review_Adapter(bean.getResult(),getActivity());
            erxfe.setAdapter(adapter);
        }

    }
}
