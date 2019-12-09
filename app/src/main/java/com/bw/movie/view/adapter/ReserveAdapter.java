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
import com.bw.movie.model.bean.ComingBean;
import com.bw.movie.model.bean.ReserveBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/11/12
 * author:金豪(Lenovo)
 * function:
 */
public class ReserveAdapter extends RecyclerView.Adapter<ReserveAdapter.CominViewHolder> {
    private List<ReserveBean.ResultBean> list;
    private Context context;

    public ReserveAdapter(List<ReserveBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CominViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.reserveadapter, null);
        return new CominViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CominViewHolder cominViewHolder, int i) {
        cominViewHolder.comin_name.setText(list.get(i).getName());
        //转换json时间
        final long releaseTime = list.get(i).getReleaseTime();
        SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日");
        String format = sdf.format(releaseTime);
        cominViewHolder.comin_time.setText(format);
        cominViewHolder.comin_like.setText(list.get(i).getWantSeeNum()+"人想看");
     //   Glide.with(context).load(list.get(i).getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(cominViewHolder.comin_inmg);
         cominViewHolder.comin_inmg.setImageURI(list.get(i).getImageUrl());
     /*   if (list.get(i).getWhetherReserve()==1) {
            cominViewHolder.comin_but.setVisibility(View.GONE);
            cominViewHolder.comin_but1.setVisibility(View.VISIBLE);
        }
        if (list.get(i).getWhetherReserve()==2) {


            cominViewHolder.comin_but.setVisibility(View.VISIBLE);
            cominViewHolder.comin_but1.setVisibility(View.GONE);
        }*/
       /* cominViewHolder.comin_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int movieId = list.get(i).getMovieId();
                OnckieButnk.Onckedfklf(movieId);
                cominViewHolder.comin_but.setVisibility(View.GONE);
                cominViewHolder.comin_but1.setVisibility(View.VISIBLE);

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CominViewHolder extends RecyclerView.ViewHolder {
       private SimpleDraweeView comin_inmg;
        private TextView comin_name,comin_time,comin_like;
        private Button comin_but,comin_but1;
        public CominViewHolder(@NonNull View itemView) {
            super(itemView);
            comin_inmg=itemView.findViewById(R.id.comin_img);
            comin_name=itemView.findViewById(R.id.comin_name);
            comin_like=itemView.findViewById(R.id.comin_like);
            comin_time=itemView.findViewById(R.id.comin_time);
            comin_but=itemView.findViewById(R.id.comin_but);
            comin_but1=itemView.findViewById(R.id.comin_but1);
        }
    }

}
