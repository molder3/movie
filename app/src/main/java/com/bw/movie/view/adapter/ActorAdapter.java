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
import com.bw.movie.model.bean.DetailsBean;

import java.util.List;

/**
 * date:2019/11/15
 * author:金豪(Lenovo)
 * function:
 */
public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {
    private List<DetailsBean.ResultBean.MovieActorBean> list;
    private Context context;

    public ActorAdapter(List<DetailsBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.actor, null);
        return new ActorViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder actorViewHolder, int i) {
        actorViewHolder.actor_acotr.setText(list.get(i).getName());
        actorViewHolder.actor_role.setText("饰: "+" "+list.get(i).getRole());

        Glide.with(context).load(list.get(i).getPhoto()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(actorViewHolder.actor_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ActorViewHolder extends RecyclerView.ViewHolder {
        private ImageView actor_img;
        private TextView actor_acotr,actor_role;
        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            actor_img=itemView.findViewById(R.id.actor_img);
            actor_acotr=itemView.findViewById(R.id.actor_acotr);
            actor_role=itemView.findViewById(R.id.actor_role);
        }
    }
}
