package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.QuyuBean;

import java.util.List;

/**
 * date:2019/11/14
 * author:金豪(Lenovo)
 * function:
 */
public class QuyutwoAdapter extends RecyclerView.Adapter<QuyutwoAdapter.QuyuViewHolder> {
    private List<QuyuBean.ResultBean> list;
    private Context context;

    public QuyutwoAdapter(List<QuyuBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public QuyuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.quyuadapter, null);
        return new QuyuViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull QuyuViewHolder quyuViewHolder, int i) {
        quyuViewHolder.item_text.setText(list.get(i).getRegionName());
        quyuViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regionName = list.get(i).getRegionName();

                mOnItemClickListener.onItemClickkk(regionName);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class QuyuViewHolder extends RecyclerView.ViewHolder {
        private TextView item_text;
        public QuyuViewHolder(@NonNull View itemView) {
            super(itemView);
            item_text=itemView.findViewById(R.id.item_text);
        }
    }
    private OnItemClickListener mOnItemClickListener;

    public void onItemClickListenered(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClickkk(String regionName);

    }
}
