package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.NearbyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder> {
    private List<NearbyBean.ResultBean> list;
    private Context context;

    public NearbyAdapter(List<NearbyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NearbyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.nearbyadapter, null);
        return new NearbyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyViewHolder nearbyViewHolder, int i) {
        nearbyViewHolder.reco_name.setText(list.get(i).getName());
        nearbyViewHolder.reco_time.setText(list.get(i).getAddress());
        nearbyViewHolder.reco_img.setImageURI(list.get(i).getLogo());
        nearbyViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = list.get(i).getId();
                OnInnerabyOcilek.OnnerbayOcked(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NearbyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView reco_img;
        private TextView reco_name,reco_time;
        public NearbyViewHolder(@NonNull View itemView) {
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

    public void setOnInnerabyOcilek(NearbyAdapter.OnInnerabyOcilek onInnerabyOcilek) {
        OnInnerabyOcilek = onInnerabyOcilek;
    }

}
