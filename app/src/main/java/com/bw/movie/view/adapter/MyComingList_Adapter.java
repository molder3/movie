package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bw.movie.R;
import com.bw.movie.model.bean.ComingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * date:2019/12/5
 * author:金豪(Lenovo)
 * function:
 */
public class MyComingList_Adapter  extends XRecyclerView.Adapter<MyComingList_Adapter.MyViewHolder>{
    private Context context;
    private List<ComingBean.ResultBean> list;
    public Item_AdapterData data_list;

    public MyComingList_Adapter(Context context, List<ComingBean.ResultBean> result) {
        this.context = context;
        this.list = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cominmovie, null, true);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder Myholder, final int position) {
        MyViewHolder holder = Myholder;
        //设置电影名称
        holder.coming_text_name.setText(list.get(position).getName());
        //设置时间戳
        long time = list.get(position).getReleaseTime();
        Date date = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        String str = format.format(date);
        holder.coming_text_time.setText(str + "上映");
        //设置观看人数
        holder.coming_text_num.setText(list.get(position).getWantSeeNum() + "人想看");
        //设置电影图片
        holder.coming_image.setImageURI(list.get(position).getImageUrl());
        //条目点击事件
        if (data_list != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data_list.onItem_Data(list.get(position).getMovieId());
                }
            });
        }
        if (list.get(position).getWhetherReserve()==1) {
            holder.comin_but.setVisibility(View.GONE);
            holder.comin_but1.setVisibility(View.VISIBLE);
        }
        if (list.get(position).getWhetherReserve()==2) {


            holder.comin_but.setVisibility(View.VISIBLE);
            holder.comin_but1.setVisibility(View.GONE);
        }
        holder.comin_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int movieId = list.get(position).getMovieId();
                OnckieButnkddd.Onckedfklf(movieId);
                holder.comin_but.setVisibility(View.GONE);
                holder.comin_but1.setVisibility(View.VISIBLE);

            }
        });

    }

    @Override
    public int getItemCount() {

            return list.size();

    }

    public class MyViewHolder extends XRecyclerView.ViewHolder {
        private TextView coming_text_name, coming_text_time, coming_text_num;
        private SimpleDraweeView coming_image;
        private Button comin_but,comin_but1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coming_text_name = itemView.findViewById(R.id.comin_name);
            coming_text_time = itemView.findViewById(R.id.comin_time);
            coming_text_num = itemView.findViewById(R.id.comin_like);
            coming_image = itemView.findViewById(R.id.comin_img);
            comin_but=itemView.findViewById(R.id.comin_but);
            comin_but1=itemView.findViewById(R.id.comin_but1);
        }
    }

    //定义接口
    public interface Item_AdapterData {
        void onItem_Data(int id);
    }

    public void setData_list(Item_AdapterData data_list) {
        this.data_list = data_list;
    }
    public interface OnckieButnkddd{
        void Onckedfklf(int movieId);
    }
    private OnckieButnkddd OnckieButnkddd;

    public void setOnckieButnkddd(MyComingList_Adapter.OnckieButnkddd onckieButnkddd) {
        OnckieButnkddd = onckieButnkddd;
    }
}
