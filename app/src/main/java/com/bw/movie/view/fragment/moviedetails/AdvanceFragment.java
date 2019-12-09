package com.bw.movie.view.fragment.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DetailsBean;
import com.bw.movie.model.bean.MovieLikeBean;
import com.bw.movie.model.bean.MovieNoLikeBean;
import com.bw.movie.present.DetailsPresent;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class AdvanceFragment extends BeasFragment<DetailsPresent> implements ICountView.Detalis {
    private JCVideoPlayer jcvideo;
    @Override
    protected int setLyout() {
        return R.layout.advance;
    }

    @Override
    protected void intiView() {
        jcvideo= getViewId(R.id.jcvideo);
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
        for (int i = 0; i <bean.getResult().getShortFilmList().size() ; i++) {
            jcvideo.setUp(bean.getResult().getShortFilmList().get(i).getVideoUrl(),"视频");
        }
    }

    @Override
    public void MovieLikeSucess(MovieLikeBean bean) {

    }

    @Override
    public void MovieNolieSunse(MovieNoLikeBean bean) {

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
