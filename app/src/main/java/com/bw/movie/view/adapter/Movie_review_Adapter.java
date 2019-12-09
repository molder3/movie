package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.MoviePingLunBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * date:2019/12/4
 * author:金豪(Lenovo)
 * function:
 */
public class Movie_review_Adapter extends RecyclerView.Adapter<Movie_review_Adapter.Movie_review_ViewHolder> {
    private List<MoviePingLunBean.ResultBean> result;
    private Context context;

    public Movie_review_Adapter(List<MoviePingLunBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Movie_review_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_moviediscuss, null);
        return new Movie_review_ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Movie_review_ViewHolder movieViewHolder, int i) {
        movieViewHolder.imag_view.setImageURI(result.get(i).getImageUrl());
        movieViewHolder.text_name.setText(result.get(i).getMovieName());
        movieViewHolder.text_director.setText("导演: " + result.get(i).getDirector());
        movieViewHolder.text_starring.setText("主演: " + result.get(i).getStarring());
        movieViewHolder.text_score.setText("评分: " + result.get(i).getMovieScore() + "分");
        movieViewHolder.text_discuss_name.setText("我的评价");
        movieViewHolder.text_discuss_content.setText(result.get(i).getMyCommentContent());
        movieViewHolder.filmReview_ratingBar.setRating((float) result.get(i).getMyCommentScore());
        movieViewHolder.text_discuss_score.setText(result.get(i).getMyCommentScore() + "分");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = formatter.format(result.get(i).getCommentTime());
        movieViewHolder.text_discuss_time.setText(format);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Movie_review_ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_discuss_time, text_discuss_score, text_discuss_content, text_discuss_name, text_score, text_starring, text_director, text_name;
        private LinearLayout linear_layout;
        private SimpleDraweeView imag_view;
        private RatingBar filmReview_ratingBar;
        public Movie_review_ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_discuss_time = itemView.findViewById(R.id.text_discuss_time);
            text_discuss_score = itemView.findViewById(R.id.text_discuss_score);
            text_discuss_content = itemView.findViewById(R.id.text_discuss_content);
            text_discuss_name = itemView.findViewById(R.id.text_discuss_name);
            text_score = itemView.findViewById(R.id.text_score);
            text_starring = itemView.findViewById(R.id.text_starring);
            text_director = itemView.findViewById(R.id.text_director);
            text_name = itemView.findViewById(R.id.text_name);
            imag_view = itemView.findViewById(R.id.imag_view);
            filmReview_ratingBar = itemView.findViewById(R.id.filmReview_ratingBar);
        }
    }
}
