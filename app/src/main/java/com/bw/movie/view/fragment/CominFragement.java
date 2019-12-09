package com.bw.movie.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.view.activity.AttentionActivity;
import com.bw.movie.view.activity.CommentActivityActivity;
import com.bw.movie.view.activity.FeedbackActivity;
import com.bw.movie.view.activity.KanguoActivity;
import com.bw.movie.view.activity.MineActivity;
import com.bw.movie.view.activity.My_MovieActivity;
import com.bw.movie.view.activity.ResertActivity;
import com.bw.movie.view.activity.SetActivity;
import com.bw.movie.view.activity.SystemActivity;
import com.bw.movie.view.activity.TicketRecordActivity;
import com.bw.movie.view.activity.UpdateActivity;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public class CominFragement extends BeasFragment {
    private ImageView seti,attchgo,reser,imag_movie_span,fankui,tick,pingl,imgp,imag_xinxi;
    private LinearLayout tudppfd;
    @Override
    protected int setLyout() {
        return R.layout.cominfragment;
    }

    @Override
    protected void intiView() {
        seti = (ImageView) getViewId(R.id.seti);
        attchgo = (ImageView) getViewId(R.id.attchgo);
        reser = (ImageView) getViewId(R.id.reser);
        fankui = (ImageView) getViewId(R.id.fankui);
        pingl = (ImageView) getViewId(R.id.pingl);
        imag_xinxi = (ImageView) getViewId(R.id.imag_xinxi);
        imgp = (ImageView) getViewId(R.id.imgp);
        tudppfd = (LinearLayout) getViewId(R.id.tudppfd);
        imag_movie_span = (ImageView) getViewId(R.id.imag_movie_span);
        tick = (ImageView) getViewId(R.id.tick);
    }

    @Override
    protected BeasPresent setPrsent() {
        return new BeasPresent();
    }

    @Override
    protected void intiData() {
         seti.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(getActivity(), SetActivity.class);
                 startActivity(intent);
             }
         });
        attchgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AttentionActivity.class);
                startActivity(intent);
            }
        });
        reser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ResertActivity.class);
                startActivity(intent);
            }
        });
        imag_movie_span.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), My_MovieActivity.class);
                startActivity(intent);
            }
        });
        fankui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), FeedbackActivity.class);
                startActivity(intent);
            }
        });
       //购票记录
        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), TicketRecordActivity.class);
                startActivity(intent);
            }
        });
        //我的
        tudppfd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), MineActivity.class);
                startActivity(intent);
            }
        });
        //我的评论
        pingl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), CommentActivityActivity.class);
                startActivity(intent);
            }
        });
        //看过的电影
        imgp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(getActivity(), KanguoActivity.class);
               startActivity(intent);
            }
        });
        //系统消息
        imag_xinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SystemActivity.class);
                startActivity(intent);
            }
        });
    }
}
