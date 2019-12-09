package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/18
 * author:金豪(Lenovo)
 * function:
 */
public class JuzhaoAdapter extends RecyclerView.Adapter<JuzhaoAdapter.JuzhaoViewHolder> {
    private List<String> list;
    private Context context;

    public JuzhaoAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public JuzhaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.juzadapter, null);
        return new JuzhaoViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull JuzhaoViewHolder holder, int position) {
        holder.poster_img.setImageURI(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  JuzhaoViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView poster_img;
        public JuzhaoViewHolder(@NonNull View itemView) {
            super(itemView);
            poster_img=itemView.findViewById(R.id.poster_img);
        }
    }
}
