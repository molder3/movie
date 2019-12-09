package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.ByPriceBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/21
 * author:金豪(Lenovo)
 * function:
 */
public class ByPriceAdapter extends RecyclerView.Adapter<ByPriceAdapter.ByPriceViewHolder> {
    private List<ByPriceBean.ResultBean> list;
    private Context context;

    public ByPriceAdapter(List<ByPriceBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ByPriceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.nearbyadapter, null);
        return new ByPriceViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ByPriceViewHolder nearbyViewHolder, int i) {
        nearbyViewHolder.reco_name.setText(list.get(i).getName());
        nearbyViewHolder.reco_time.setText(list.get(i).getAddress());
        nearbyViewHolder.reco_img.setImageURI(list.get(i).getLogo());
        nearbyViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = list.get(i).getCinemaId();
                OnInnerabyOcilek.OnnerbayOcked(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ByPriceViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView reco_img;
        private TextView reco_name,reco_time;
        public ByPriceViewHolder(@NonNull View itemView) {
            super(itemView);
            reco_img=itemView.findViewById(R.id.reco_img);
            reco_time=itemView.findViewById(R.id.reco_time);
            reco_name=itemView.findViewById(R.id.reco_name);
        }
    }
    public interface OnInnerabyOcilek{
        void OnnerbayOcked(int id);
    }
    private OnInnerabyOcilek OnInnerabyOcilek;

    public void setOnInnerabyOcilek(OnInnerabyOcilek onInnerabyOcilek) {
        OnInnerabyOcilek = onInnerabyOcilek;
    }
}
