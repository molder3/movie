package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.PbrqBean;

import java.util.List;

/**
 * date:2019/11/21
 * author:金豪(Lenovo)
 * function:
 */
public class PdrqAdapter extends RecyclerView.Adapter<PdrqAdapter.PdrqViewHolder> {
    private List<PbrqBean.ResultBean> list;
    private Context context;

    public PdrqAdapter(List<PbrqBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public PdrqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pbrq, null);
        return new PdrqViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PdrqViewHolder pdrqViewHolder, int i) {
        pdrqViewHolder.pb_name.setText(list.get(i).getScreeningHall());
        pdrqViewHolder.pb_kas.setText(list.get(i).getBeginTime());
        pdrqViewHolder.pb_endf.setText(list.get(i).getEndTime());
        pdrqViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int blue = 0;
                pdrqViewHolder.reledf.setBackgroundColor(blue);
                callBack.getBack("0");
                callBack.getId(list.get(i).getId());
            }
        });
        callBack.getId(list.get(i).getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PdrqViewHolder extends RecyclerView.ViewHolder {
        private TextView pb_name,pb_kas,pb_endf;
        private RelativeLayout reledf;
        public PdrqViewHolder(@NonNull View itemView) {
            super(itemView);
            pb_endf=itemView.findViewById(R.id.pb_endf);
            pb_name=itemView.findViewById(R.id.pb_name);
            pb_kas=itemView.findViewById(R.id.pb_kas);
            reledf=itemView.findViewById(R.id.pb_rl);
        }
    }
    public interface iCallBack {
        void getBack(String s);
        void getId(int idd);
    }
    iCallBack callBack;

    public void setCallBack(iCallBack callBack) {
        this.callBack = callBack;
    }
}
