package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bw.movie.R;
import com.bw.movie.model.bean.HotBean;
import com.bw.movie.model.bean.HotmovieBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * date:2019/12/5
 * author:金豪(Lenovo)
 * function:
 */
public class MyShowingList_Adapter extends XRecyclerView.Adapter<MyShowingList_Adapter.MyViewHolder> {
    private Context context;
    private List<HotmovieBean.ResultBean> result;
    public Item_AdapterData data_list;

    public MyShowingList_Adapter(Context context, List<HotmovieBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotmovie, null, true);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder Myholder, final int position) {
        MyViewHolder holder = Myholder;
        holder.zzty_name.setText(result.get(position).getName());
            /* zzryViewHolder.zzty_dao.setText("导演:"+list.get(i).getDirector());
             zzryViewHolder.zzty_zhu.setText("主演:"+list.get(i).getStarring());*/
        holder.zzty_ping.setText(+result.get(position).getScore()+"");
        //  Glide.with(context).load(list.get(position).getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.zzty_img);
        holder.zzty_img.setImageURI(result.get(position).getImageUrl());
        //条目点击事件
        if (data_list != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    data_list.onItem_Data(result.get(position).getMovieId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {

            return result.size();

    }

    public class MyViewHolder extends XRecyclerView.ViewHolder {
        private TextView zzty_name,zzty_dao,zzty_zhu,zzty_ping;
        private SimpleDraweeView zzty_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            zzty_name=itemView.findViewById(R.id.zzry_name);
            /*zzty_dao=itemView.findViewById(R.id.zzry_dao);
            zzty_zhu=itemView.findViewById(R.id.zzry_zhu);*/
            zzty_ping=itemView.findViewById(R.id.zzry_ping);
            zzty_img=itemView.findViewById(R.id.zzry_img);
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
