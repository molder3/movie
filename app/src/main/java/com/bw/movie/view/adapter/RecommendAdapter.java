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
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder> {

    private List<RecommendBean.ResultBean> list;
    private Context context;

    public RecommendAdapter(List<RecommendBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recommendadapter, null);
        return new RecommendViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder nearbyViewHolder, int i) {
        nearbyViewHolder.nearby_name.setText(list.get(i).getName());
        nearbyViewHolder.nearby_time.setText(list.get(i).getAddress());
        nearbyViewHolder.nearby_img.setImageURI(list.get(i).getLogo());
        nearbyViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = list.get(i).getId();
                mOnItemClickListenerid.onItemClickid(id);
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
        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);
            nearby_img=itemView.findViewById(R.id.nearby_img);
            nearby_name=itemView.findViewById(R.id.nearby_name);
            nearby_time=itemView.findViewById(R.id.nearby_time);
            nearby_lc=itemView.findViewById(R.id.nearby_lc);
        }
    }
    private OnItemClickListener mOnItemClickListenerid;

    public void setmOnItemClickListenerid(OnItemClickListener mOnItemClickListenerid) {
        this.mOnItemClickListenerid = mOnItemClickListenerid;
    }

    public interface OnItemClickListener{
        void onItemClickid(int id);

    }
}
