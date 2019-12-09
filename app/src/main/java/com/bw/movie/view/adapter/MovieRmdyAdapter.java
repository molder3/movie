package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.model.bean.BeonBean;
import com.bw.movie.model.bean.HotmovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/11/12
 * author:金豪(Lenovo)
 * function:
 */
public class MovieRmdyAdapter extends RecyclerView.Adapter<MovieRmdyAdapter.MovieRmdyViewHolder>{

    private List<BeonBean.ResultBean> rmdy;
    private Context context;

    public MovieRmdyAdapter(List<BeonBean.ResultBean> rmdy, Context context) {
        this.rmdy = rmdy;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieRmdyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hotmovie, null);
        return new MovieRmdyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRmdyViewHolder movieRmdyViewHolder, int i) {
        movieRmdyViewHolder.zzty_name.setText(rmdy.get(i).getName());
        movieRmdyViewHolder.zzty_ping.setText(rmdy.get(i).getScore()+"");
      movieRmdyViewHolder.zzty_img.setImageURI(rmdy.get(i).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return rmdy.size();
    }

    class MovieRmdyViewHolder extends RecyclerView.ViewHolder {
        private TextView zzty_name,zzty_ping;
        private SimpleDraweeView zzty_img;
        public MovieRmdyViewHolder(@NonNull View itemView) {
            super(itemView);
            zzty_name=itemView.findViewById(R.id.zzry_name);
            zzty_ping=itemView.findViewById(R.id.zzry_ping);
            zzty_img=itemView.findViewById(R.id.zzry_img);
        }
    }
}
