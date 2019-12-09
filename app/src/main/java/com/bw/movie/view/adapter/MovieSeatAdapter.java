package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.SetleBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * date:2019/11/21
 * author:金豪(Lenovo)
 * function:
 */
public class MovieSeatAdapter extends RecyclerView.Adapter<MovieSeatAdapter.MovieVIewHolder>{
   private List<SetleBean.ResultBean> result;
   private Context context;

    public MovieSeatAdapter(List<SetleBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.setle, null);
        return new MovieVIewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull  MovieVIewHolder movieVIewHolder, int position) {
        int status = result.get(position).getStatus();
        if (status == 1) {
            movieVIewHolder.cheBox.setChecked(false);
             movieVIewHolder.cheBox1.setVisibility(View.INVISIBLE);
             movieVIewHolder.cheBox.setVisibility(View.VISIBLE);
        } else if (status == 2) {
            movieVIewHolder.cheBox.setChecked(true);
            movieVIewHolder.cheBox.setBackgroundColor(R.drawable.myy_shape);
            movieVIewHolder.cheBox.setVisibility(View.INVISIBLE);
            movieVIewHolder.cheBox1.setVisibility(View.VISIBLE);
        }
        final ArrayList<String> list=new ArrayList<>();
        movieVIewHolder.cheBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (movieVIewHolder.cheBox.isChecked()) {
                    result.get(position).setStatus(3);
                    String row1 = result.get(position).getRow();
                    String seat2 = result.get(position).getSeat();
                    String s = row1 + "-" + seat2;
                    list.addAll(Collections.singleton(s));
                    callBack.getStrng(list);
                    callBack.getBack(result.get(position).getRow() + "排" + result.get(position).getSeat() + "座");
                } else {
                    result.get(position).setStatus(1);
                    callBack.getBack("取消选座");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MovieVIewHolder extends RecyclerView.ViewHolder {
        private CheckBox cheBox;
        private CheckBox cheBox1;
        public MovieVIewHolder(@NonNull View itemView) {
            super(itemView);
            cheBox=itemView.findViewById(R.id.chek);
            cheBox1=itemView.findViewById(R.id.chek1);
        }
    }
    public interface CallBack {
        void getBack(String s);
        void getStrng(ArrayList<String> list);
    }

    CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
