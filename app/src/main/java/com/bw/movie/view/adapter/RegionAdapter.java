package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.RegionBean;

import java.util.List;

/**
 * date:2019/11/14
 * author:金豪(Lenovo)
 * function:
 */
public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.RegionViewHolder> {
    private List<RegionBean.ResultBean> list;
    private Context context;

    public RegionAdapter(List<RegionBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RegionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.regionadapter, null);
        return new RegionViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RegionViewHolder regionViewHolder, int i) {
        regionViewHolder.item_text.setText(list.get(i).getName());
          regionViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    class RegionViewHolder extends RecyclerView.ViewHolder {
        private TextView item_text;
        public RegionViewHolder(@NonNull View itemView) {
            super(itemView);
            item_text=itemView.findViewById(R.id.item_text);
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
