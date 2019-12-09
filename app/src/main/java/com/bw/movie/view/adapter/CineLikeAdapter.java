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
import com.bw.movie.model.RecommendBean;
import com.bw.movie.model.bean.CineGuanzBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class CineLikeAdapter extends RecyclerView.Adapter<CineLikeAdapter.RecommendViewHolder> {

    private List<CineGuanzBean.ResultBean> list;
    private Context context;

    public CineLikeAdapter(List<CineGuanzBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recommendadapter1, null);
        return new RecommendViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder nearbyViewHolder, int i) {
        nearbyViewHolder.nearby_name.setText(list.get(i).getName());
        nearbyViewHolder.nearby_time.setText(list.get(i).getAddress());
        nearbyViewHolder.nearby_img.setImageURI(list.get(i).getLogo());

        nearbyViewHolder.xxxxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cinemaId = list.get(i).getCinemaId();
                Onckiletedf.Onckiled(cinemaId);
                Onckiletedf.Ondksad(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {
        private TextView nearby_name,nearby_time,nearby_lc;
        private SimpleDraweeView nearby_img;
        private ImageView xxxxx;
        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);
            nearby_img=itemView.findViewById(R.id.nearby_img);
            nearby_name=itemView.findViewById(R.id.nearby_name);
            nearby_time=itemView.findViewById(R.id.nearby_time);
            nearby_lc=itemView.findViewById(R.id.nearby_lc);
            xxxxx=itemView.findViewById(R.id.xxxxx);
        }
    }
    public interface Onckiletedf{
        void Onckiled(int cinemaId);
        void Ondksad(int i);
    }
    private Onckiletedf Onckiletedf;

    public void setOnckiletedf(CineLikeAdapter.Onckiletedf onckiletedf) {
        Onckiletedf = onckiletedf;
    }
}
