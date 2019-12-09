package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.MovieTickBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * date:2019/12/2
 * author:金豪(Lenovo)
 * function:
 */
public class My_Movie_Adapter extends RecyclerView.Adapter<My_Movie_Adapter.My_Movie_ViewHolder> {
     private List<MovieTickBean.ResultBean> list;
     private Context context;
    private Date date;
    public My_Movie_Adapter(List<MovieTickBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public My_Movie_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.my_movie_item, null);
        return new My_Movie_ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull My_Movie_ViewHolder holder, int position) {
        holder.text_cinema.setText(list.get(position).getCinemaName());
        holder.text_name.setText(list.get(position).getMovieName());
        holder.text_screeningHall.setText(list.get(position).getScreeningHall());
        holder.text_zuo.setText(list.get(position).getSeat());
        //设置时间戳
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        long time = list.get(position).getCreateTime();
        date = new Date(time);
        String str = format.format(date);
        holder.text_date.setText(str);
        String beginTime = list.get(position).getBeginTime();
        holder.text_time.setText(beginTime);
        holder.bt_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = list.get(position).getId();
                OnCikedfbutteon.OncikebuttSunsd(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class My_Movie_ViewHolder extends RecyclerView.ViewHolder {
        private Button bt_reservation;
        private TextView text_time, text_date, text_screeningHall, text_cinema, text_zuo, text_name;
        public My_Movie_ViewHolder(@NonNull View itemView) {
            super(itemView);
            bt_reservation = itemView.findViewById(R.id.bt_reservation);
            text_time = itemView.findViewById(R.id.text_time);
            text_date = itemView.findViewById(R.id.text_date);
            text_screeningHall = itemView.findViewById(R.id.text_screeningHall);
            text_cinema = itemView.findViewById(R.id.text_cinema);
            text_zuo = itemView.findViewById(R.id.text_zuo);
            text_name = itemView.findViewById(R.id.text_name);
        }
    }
    public interface OnCikedfbutteon{
        void OncikebuttSunsd(int id);
    }
    private OnCikedfbutteon OnCikedfbutteon;

    public void setOnCikedfbutteon(My_Movie_Adapter.OnCikedfbutteon onCikedfbutteon) {
        OnCikedfbutteon = onCikedfbutteon;
    }
}
