package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.DimmovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/30
 * author:金豪(Lenovo)
 * function:
 */
public class DimovieAdapter extends RecyclerView.Adapter<DimovieAdapter.DimovieViewHolder> {
    private List<DimmovieBean.ResultBean> list;
    private Context context;

    public DimovieAdapter(List<DimmovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DimovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.afzzry, null);
        return  new DimovieViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DimovieViewHolder holder, int i) {
        holder.hh_dao.setText("导演:"+list.get(i).getDirector());
        holder.hh_name.setText(list.get(i).getName());
        holder.hh_zhu.setText("主演:"+list.get(i).getStarring());
        holder.hh_ping.setText("评分:"+list.get(i).getScore()+"");
        holder.hh_img.setImageURI(list.get(i).getImageUrl());
    }

    @Override
    public int getItemCount() {

        return list.size();

    }

    class DimovieViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView hh_img;
        private TextView hh_name,hh_dao,hh_zhu,hh_ping;
        private Button hh_but;
        public DimovieViewHolder(@NonNull View itemView) {
            super(itemView);
            hh_img=itemView.findViewById(R.id.hh_img);
            hh_dao=itemView.findViewById(R.id.hh_dao);
            hh_name=itemView.findViewById(R.id.hh_name);
            hh_zhu=itemView.findViewById(R.id.hh_zhu);
            hh_ping=itemView.findViewById(R.id.hh_ping);
            hh_but=itemView.findViewById(R.id.hh_but);
        }
    }
}
