package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.model.bean.BeonBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/12/5
 * author:金豪(Lenovo)
 * function:
 */
public class MyHotMovie_Adapter extends RecyclerView.Adapter {
    private List<BeonBean.ResultBean> list;
    private Context context;
   public Item_AdapterData data_list;


    public MyHotMovie_Adapter(Context context, List<BeonBean.ResultBean> beo_list) {
        this.list = beo_list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;
        if (viewType == 0) {
            view = LayoutInflater.from(context).inflate(R.layout.item_hot_movie_one, null);
            viewHolder = new MyViewHolder01(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_hot_movie_two, null);
            viewHolder = new MyViewHolder02(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (position == 0) {
            MyViewHolder01 viewHolder01 = (MyViewHolder01) holder;
            viewHolder01.hot_tv_name_one.setText(list.get(position).getName());
            viewHolder01.hot_tv_score_one.setText(list.get(position).getScore() + "分");
          //  viewHolder01.hot_image_pic_one.setImageURI(list.get(position).getImageUrl());
            Glide.with(context).load(list.get(position).getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(viewHolder01.hot_image_pic_one);
            //条目点击事件
            if (data_list != null) {
                viewHolder01.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        data_list.onItem_Data(list.get(position).getMovieId());
                    }
                });
            }
        } else {
            MyViewHolder02 viewHolder02 = (MyViewHolder02) holder;
            viewHolder02.hot_tv_movieName_two.setText(list.get(position).getName());
            viewHolder02.hot_tv_score_two.setText(list.get(position).getScore() + "分");
            viewHolder02.hot_image_two.setImageURI(list.get(position).getImageUrl());

            //条目点击事件
            if (data_list != null) {
                viewHolder02.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        data_list.onItem_Data(list.get(position).getMovieId());
                    }
                });
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {

            return list.size();

    }
    public class MyViewHolder01 extends RecyclerView.ViewHolder {
        private TextView hot_tv_name_one, hot_tv_score_one;
        private ImageView hot_image_pic_one;
        private Button bt_hot_movie_one;

        public MyViewHolder01(@NonNull View itemView) {
            super(itemView);
            hot_tv_name_one = itemView.findViewById(R.id.rmdy_name);
            hot_tv_score_one = itemView.findViewById(R.id.rmdy_ping);
            hot_image_pic_one = itemView.findViewById(R.id.rmdy_img);
            bt_hot_movie_one = itemView.findViewById(R.id.rmdy_but);
        }
    }

    public class MyViewHolder02 extends RecyclerView.ViewHolder {
        private TextView hot_tv_movieName_two, hot_tv_score_two;
        private SimpleDraweeView hot_image_two;
        private Button hot_bt_two;

        public MyViewHolder02(@NonNull View itemView) {
            super(itemView);
            hot_tv_movieName_two = itemView.findViewById(R.id.zzry_name);
            hot_tv_score_two = itemView.findViewById(R.id.zzry_ping);
            hot_image_two = itemView.findViewById(R.id.zzry_img);
            hot_bt_two = itemView.findViewById(R.id.zzry_but);
        }
    }

    //定义接口
    public interface Item_AdapterData {
        void onItem_Data(int id);
    }

    public void setData_list(Item_AdapterData data_list) {
        this.data_list = data_list;
    }
}
