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
import com.bw.movie.model.bean.TimeBean;
import com.bw.movie.view.activity.PopupwindowActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/11/20
 * author:金豪(Lenovo)
 * function:
 */
public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeViewHolder> {
    private List<String> list;
    private Context context;
    private String[] str = new String[]{};

    public TimeAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.time, null);
        return new TimeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {

        holder.time_text.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = list.get(position);
                OnIntimeOcilek.OnTimeOcked(s);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TimeViewHolder extends RecyclerView.ViewHolder {
       private TextView time_text;
        public TimeViewHolder(@NonNull View itemView) {
            super(itemView);
            time_text=itemView.findViewById(R.id.time_text);
        }
    }
    public interface OnIntimeOcilek{
        void OnTimeOcked(String s);
    }
    private OnIntimeOcilek OnIntimeOcilek;

    public void setOnIntimeOcilek(TimeAdapter.OnIntimeOcilek onIntimeOcilek) {
        OnIntimeOcilek = onIntimeOcilek;
    }
}
