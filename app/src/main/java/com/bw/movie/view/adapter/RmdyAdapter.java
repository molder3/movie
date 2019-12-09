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

import java.util.List;

/**
 * date:2019/11/12
 * author:金豪(Lenovo)
 * function:
 */
public class RmdyAdapter extends RecyclerView.Adapter<RmdyAdapter.RmdyViewHolder> {

    private List<BeonBean.ResultBean> list;
    private Context context;

    public RmdyAdapter(List<BeonBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull

    @Override
    public RmdyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rmdymovie, null);
        return new RmdyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RmdyViewHolder rmdyViewHolder, int i) {
        rmdyViewHolder.rmdy_name.setText(list.get(i).getName());
        rmdyViewHolder.rmdy_ping.setText(list.get(i).getScore()+"");
        Glide.with(context).load(list.get(i).getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(rmdyViewHolder.rmdy_img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RmdyViewHolder extends RecyclerView.ViewHolder {
        private ImageView rmdy_img;
        private TextView rmdy_name,rmdy_ping;
        public RmdyViewHolder(@NonNull View itemView) {
            super(itemView);
            rmdy_img=itemView.findViewById(R.id.rmdy_img);
            rmdy_name=itemView.findViewById(R.id.rmdy_name);
            rmdy_ping=itemView.findViewById(R.id.rmdy_ping);
        }
    }
}
