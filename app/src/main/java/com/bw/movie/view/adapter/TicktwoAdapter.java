package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.TickBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/12/3
 * author:金豪(Lenovo)
 * function:
 */
public class TicktwoAdapter extends RecyclerView.Adapter<TicktwoAdapter.TicktwoViewHolder> {
    private List<TickBean.ResultBean> list;
    private Context context;

    public TicktwoAdapter(List<TickBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TicktwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ticktwoadapter, null);
        return new TicktwoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TicktwoViewHolder holder, int position) {
        holder.ticket_name.setText(list.get(position).getMovieName());
        holder.ticket_address.setText(list.get(position).getOrderId());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sdf.format(list.get(position).getCreateTime());
        holder.ticket_tv_delete.setText(format);
        holder.ticket_src.setImageURI(list.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TicktwoViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView ticket_src;
        private TextView ticket_name,ticket_address,ticket_tv_delete;
        public TicktwoViewHolder(@NonNull View itemView) {
            super(itemView);
            ticket_tv_delete=itemView.findViewById(R.id.ticket_tv_delete);
            ticket_src=itemView.findViewById(R.id.ticket_src);
            ticket_name=itemView.findViewById(R.id.ticket_name);
            ticket_address=itemView.findViewById(R.id.ticket_address);

        }
    }
}
