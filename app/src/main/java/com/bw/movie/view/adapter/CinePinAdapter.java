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
import com.bw.movie.model.bean.CinePinglunBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * date:2019/11/29
 * author:金豪(Lenovo)
 * function:
 */
public class CinePinAdapter extends RecyclerView.Adapter<CinePinAdapter.CinePinViewHolder> {
     private List<CinePinglunBean.ResultBean>  list;
     private Context context;

    public CinePinAdapter(List<CinePinglunBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CinePinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.cinepinadapter, null);
        return new CinePinViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CinePinViewHolder holder, int position) {
           holder.pj_tv.setText(list.get(position).getCommentUserName());
           holder.pj_iv.setImageURI(list.get(position).getCommentHeadPic());
           holder.pj_num.setText(list.get(position).getGreatNum()+"");
        long commentTime = list.get(position).getCommentTime();
        SimpleDateFormat format=new SimpleDateFormat("MM-dd HH:mm");
        String format1 = format.format(commentTime);
        holder.pj_time.setText(format1);
        holder.movie_evaluate.setText(list.get(position).getCommentContent());
        holder.evaluate_dz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.evaluate_dz.setVisibility(View.GONE);
                holder.evaluate_dz1.setVisibility(View.VISIBLE);

            }
        });
        holder.evaluate_dz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.evaluate_dz1.setVisibility(View.GONE);
                holder.evaluate_dz.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CinePinViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView pj_iv;
        private TextView pj_tv,pj_time,pj_num,movie_evaluate;
        private ImageView evaluate_dz,evaluate_dz1;
        public CinePinViewHolder(@NonNull View itemView) {
            super(itemView);
            pj_iv=itemView.findViewById(R.id.pj_iv);
            pj_tv=itemView.findViewById(R.id.pj_tv);
            pj_time=itemView.findViewById(R.id.pj_time);
            movie_evaluate=itemView.findViewById(R.id.movie_evaluate);
            pj_num=itemView.findViewById(R.id.pj_num);
            evaluate_dz=itemView.findViewById(R.id.evaluate_dz);
            evaluate_dz1=itemView.findViewById(R.id.evaluate_dz1);
        }
    }
}
