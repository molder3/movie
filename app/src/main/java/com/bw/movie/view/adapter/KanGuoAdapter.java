package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.KanguoMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/12/5
 * author:金豪(Lenovo)
 * function:
 */
public class KanGuoAdapter extends RecyclerView.Adapter<KanGuoAdapter.KanGuoViewHolder> {
    private List<KanguoMovieBean.ResultBean> list;
    private Context context;

    public KanGuoAdapter(List<KanguoMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public KanGuoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.kanguoadapter, null);
        return new KanGuoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull KanGuoViewHolder holder, int position) {
        holder.simpledr.setImageURI(list.get(position).getImageUrl());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm 观影");
        String format = sdf.format(list.get(position).getEndTime());
        holder.time.setText(format);
        holder.name.setText(list.get(position).getMovieName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class KanGuoViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpledr;
        private TextView name,time;
        private Button buter;
        public KanGuoViewHolder(@NonNull View itemView) {
            super(itemView);
            buter=itemView.findViewById(R.id.buter);
            time=itemView.findViewById(R.id.time);
            name=itemView.findViewById(R.id.name);
            simpledr=itemView.findViewById(R.id.simpledr);
        }
    }
}
