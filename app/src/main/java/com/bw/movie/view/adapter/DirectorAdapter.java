package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.DetailsBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class DirectorAdapter extends RecyclerView.Adapter<DirectorAdapter.DirectorViewHolder> {
    private List<DetailsBean.ResultBean.MovieDirectorBean> list;
    private Context context;

    public DirectorAdapter(List<DetailsBean.ResultBean.MovieDirectorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public DirectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.director, null);
        return new DirectorViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorViewHolder directorViewHolder, int i) {
        directorViewHolder.director_director.setText(list.get(i).getName());
        directorViewHolder.director_img.setImageURI(list.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DirectorViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView director_img;
        private TextView director_director;
        public DirectorViewHolder(@NonNull View itemView) {
            super(itemView);
            director_img=itemView.findViewById(R.id.director_img1);
            director_director=itemView.findViewById(R.id.director_director);
        }
    }
}
