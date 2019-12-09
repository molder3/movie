package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.CinemaPingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/12/4
 * author:金豪(Lenovo)
 * function:
 */
public class Cinema_review_Adapter extends RecyclerView.Adapter<Cinema_review_Adapter.Cinema_review_ViewHolder>{
    private List<CinemaPingBean.ResultBean> result;
    private Context context;

    public Cinema_review_Adapter(List<CinemaPingBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Cinema_review_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_cinemdiscuss, null);
        return new Cinema_review_ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Cinema_review_ViewHolder movieViewHolder, int i) {

        movieViewHolder.imag_view.setImageURI(result.get(i).getLogo());
        movieViewHolder.text_name.setText(result.get(i).getCinemaName());
        movieViewHolder.text_director.setText(result.get(i).getAddress());
        movieViewHolder.text_starring.setText(result.get(i).getDistance() + "km");
        movieViewHolder.text_discuss_content.setText(result.get(i).getMyCommentContent());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = formatter.format(result.get(i).getCommentTime());
        movieViewHolder.text_discuss_time.setText(format);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Cinema_review_ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_discuss_time, text_discuss_content, text_discuss_name, text_starring, text_director, text_name;
        private LinearLayout linear_layout;
        private SimpleDraweeView imag_view;
        public Cinema_review_ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_discuss_time = itemView.findViewById(R.id.text_discuss_time);
            text_discuss_content = itemView.findViewById(R.id.text_discuss_content);
            text_discuss_name = itemView.findViewById(R.id.text_discuss_name);
            linear_layout = itemView.findViewById(R.id.linear_layout);
            text_starring = itemView.findViewById(R.id.text_starring);
            text_director = itemView.findViewById(R.id.text_director);
            text_name = itemView.findViewById(R.id.text_name);
            imag_view = itemView.findViewById(R.id.imag_view);
        }
    }
}
