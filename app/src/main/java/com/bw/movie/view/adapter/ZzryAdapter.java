package com.bw.movie.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;
import com.bw.movie.model.bean.HotmovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2019/11/12
 * author:金豪(Lenovo)
 * function:
 */
public class ZzryAdapter extends RecyclerView.Adapter<ZzryAdapter.ZzryViewHolder> {
    private List<HotmovieBean.ResultBean> list;
    private Context context;

    public ZzryAdapter(List<HotmovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ZzryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hotmovie, null);
        return new ZzryViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ZzryViewHolder holder, int position) {
        holder.zzty_name.setText(list.get(position).getName());
            /* zzryViewHolder.zzty_dao.setText("导演:"+list.get(i).getDirector());
             zzryViewHolder.zzty_zhu.setText("主演:"+list.get(i).getStarring());*/
        holder.zzty_ping.setText(+list.get(position).getScore()+"");
      //  Glide.with(context).load(list.get(position).getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.zzty_img);
        holder.zzty_img.setImageURI(list.get(position).getImageUrl());
        if (ItemClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemClickListener.ItemClickListener(list.get(position).getMovieId(),list.get(position).getImageUrl());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ZzryViewHolder extends RecyclerView.ViewHolder {
        private TextView zzty_name,zzty_dao,zzty_zhu,zzty_ping;
         private SimpleDraweeView zzty_img;

        public ZzryViewHolder(@NonNull View itemView) {
            super(itemView);
            zzty_name=itemView.findViewById(R.id.zzry_name);
            /*zzty_dao=itemView.findViewById(R.id.zzry_dao);
            zzty_zhu=itemView.findViewById(R.id.zzry_zhu);*/
            zzty_ping=itemView.findViewById(R.id.zzry_ping);
            zzty_img=itemView.findViewById(R.id.zzry_img);
        }
    }
    private ItemClickListener ItemClickListener;
    public interface ItemClickListener{
        void ItemClickListener(int movieid,String imageUrl);
    }
    public void  setItemClickListener(ItemClickListener ItemClickListener){
        this.ItemClickListener=ItemClickListener;
    }
}
