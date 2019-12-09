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
import com.bw.movie.model.bean.WeisheBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/11/18
 * author:金豪(Lenovo)
 * function:
 */
public class WeishenAdapter extends RecyclerView.Adapter<WeishenAdapter.WeishenViewHolder> {
    private List<WeisheBean.ResultBean> list;
    private Context context;

    public WeishenAdapter(List<WeisheBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public WeishenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.weishenadapter, null);
        return new WeishenViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull WeishenViewHolder filmViewHolder, int i) {
        filmViewHolder.film_name.setText(list.get(i).getCommentUserName());
        final long releaseTime = list.get(i).getCommentTime();
        /* int score = list.get(i).getScore();*/
        /* Float d=Float.valueOf(score).floatValue();*/

        filmViewHolder.film_xing.setText(list.get(i).getScore()+"");
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd HH:mm");
        String format = sdf.format(releaseTime);
        filmViewHolder.film_time.setText(format);
        filmViewHolder.film_img.setImageURI(list.get(i).getCommentHeadPic());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class WeishenViewHolder extends RecyclerView.ViewHolder {
        private TextView film_pl,film_name,film_time,film_xing;
        private SimpleDraweeView film_img;
        public WeishenViewHolder(@NonNull View itemView) {
            super(itemView);
            film_name=itemView.findViewById(R.id.film_name);
            film_pl=itemView.findViewById(R.id.film_pl);
            film_time=itemView.findViewById(R.id.film_time);
            film_xing=itemView.findViewById(R.id.film_xing);
            film_img=itemView.findViewById(R.id.film_img);
        }
    }
}
