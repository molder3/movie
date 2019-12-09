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
public class TickoneAdapter extends RecyclerView.Adapter<TickoneAdapter.TickoneViewHolder> {
    private List<TickBean.ResultBean> list;
    private Context context;

    public TickoneAdapter(List<TickBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TickoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tickadapter, null);
        return new TickoneViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TickoneViewHolder holder, int position) {
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

    class TickoneViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView ticket_src;
        private TextView ticket_name,orid,ticket_address,orid2,ticket_tv_delete;
        public TickoneViewHolder(@NonNull View itemView) {
            super(itemView);
            ticket_tv_delete=itemView.findViewById(R.id.ticket_tv_delete);
            ticket_src=itemView.findViewById(R.id.ticket_src);
            ticket_name=itemView.findViewById(R.id.ticket_name);
            orid=itemView.findViewById(R.id.orid);
            ticket_address=itemView.findViewById(R.id.ticket_address);
            orid2=itemView.findViewById(R.id.orid2);
        }
    }
}
