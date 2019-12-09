package com.bw.movie.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.BeonBean;
import com.bw.movie.model.bean.ComingBean;
import com.bw.movie.model.bean.HotmovieBean;
import com.bw.movie.view.activity.MoviedetailsActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/**
 * date:2019/12/5
 * author:金豪(Lenovo)
 * function:
 */
public class XRccycler_Adapter extends XRecyclerView.Adapter{
    private List<BannerBean.ResultBean> banner_list;
    private List<HotmovieBean.ResultBean> hotm_list;
    private List<BeonBean.ResultBean> beo_list;
    private List<ComingBean.ResultBean> comin_list;
    private Context context;

    public XRccycler_Adapter(List<BannerBean.ResultBean> banner_list, List<HotmovieBean.ResultBean> hotm_list, List<BeonBean.ResultBean> beo_list, List<ComingBean.ResultBean> comin_list, Context context) {
        this.banner_list = banner_list;
        this.hotm_list = hotm_list;
        this.beo_list = beo_list;
        this.comin_list = comin_list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        }
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             View view=null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
                return new MyBannerViewHolder(view);
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.item_hot_showing, parent, false);
                return new MyReleaseViewHolder(view);
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.item_coming_soon, parent, false);
                return new MyComingHolder(view);
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.item_hot_movie, parent, false);
                return new MyMovieHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int type = getItemViewType(position);
        LinearLayoutManager linearLayoutManager = null;
        switch (type){
            case 0:
                final MyBannerViewHolder holder1 = (MyBannerViewHolder) holder;
                AbstractList<SimpleBannerInfo> info = new AbstractList<SimpleBannerInfo>() {
                    @Override
                    public SimpleBannerInfo get(int index) {
                        return null;
                    }

                    @Override
                    public int size() {
                        return banner_list.size();
                    }
                };
                holder1.banner.setBannerData(R.layout.simpledraweeview, info);
                holder1.banner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, final int position) {
                        String imageUrl = banner_list.get(position).getImageUrl();
                        SimpleDraweeView simpleDraweeView = view.findViewById(R.id.my_image_view);
                        DraweeController controller = Fresco.newDraweeControllerBuilder()
                                .setUri(imageUrl)
                                .setAutoPlayAnimations(true).build();
                        simpleDraweeView.setController(controller);

                        simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String picture = banner_list.get(position).getImageUrl();
                                final List<String> strings = Arrays.asList(picture.split("="));
                                String s = strings.get(1);
                                int movieid = Integer.parseInt(s);
                                Intent intent = new Intent(context, MoviedetailsActivity.class);
                                intent.putExtra("movieId", movieid);
                                context.startActivity(intent);
                            }
                        });
                    }
                });
                break;
            case 1:
                MyReleaseViewHolder release_holder = (MyReleaseViewHolder) holder;
                linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                release_holder.recycler_hot_showing.setLayoutManager(linearLayoutManager);
                MyShowingList_Adapter showListAdapter = new MyShowingList_Adapter(context, hotm_list);
                release_holder.recycler_hot_showing.setAdapter(showListAdapter);

                showListAdapter.setData_list(new MyShowingList_Adapter.Item_AdapterData() {
                    @Override
                    public void onItem_Data(int id) {
                        Intent intent = new Intent(context, MoviedetailsActivity.class);
                        intent.putExtra("movieId", id);
                        context.startActivity(intent);
                    }
                });
                break;
            case 2:
                MyComingHolder comingHolder = (MyComingHolder) holder;
                MyComingList_Adapter comingList_adapter = new MyComingList_Adapter(context,comin_list);
                linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                comingHolder.recycler_coming_soon.setLayoutManager(linearLayoutManager);

                comingHolder.recycler_coming_soon.setAdapter(comingList_adapter);

                comingList_adapter.setData_list(new MyComingList_Adapter.Item_AdapterData() {
                    @Override
                    public void onItem_Data(int id) {
                        Intent intent = new Intent(context, MoviedetailsActivity.class);
                        intent.putExtra("movieId", id);
                        context.startActivity(intent);
                    }

                });
              comingList_adapter.setOnckieButnkddd(new MyComingList_Adapter.OnckieButnkddd() {
                  @Override
                  public void Onckedfklf(int movieId) {
                      OnckieButnk.Onckedfklf(movieId);
                  }
              });
                break;
            case 3:
                MyMovieHolder movieHolder = (MyMovieHolder) holder;
                MyHotMovie_Adapter hotMovie_adapter = new MyHotMovie_Adapter(context, beo_list);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
                gridLayoutManager.setAutoMeasureEnabled(true);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (position == 0) {
                            return 3;
                        }
                        return 1;
                    }
                });
                movieHolder.recycler_hot_movie.setAdapter(hotMovie_adapter);
                movieHolder.recycler_hot_movie.setLayoutManager(gridLayoutManager);

                hotMovie_adapter.setData_list(new MyHotMovie_Adapter.Item_AdapterData() {
                    @Override
                    public void onItem_Data(int id) {
                        Intent intent = new Intent(context, MoviedetailsActivity.class);
                        intent.putExtra("movieId", id);
                        context.startActivity(intent);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyBannerViewHolder extends RecyclerView.ViewHolder {
        private XBanner banner;

        public MyBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=  itemView.findViewById(R.id.banner);
        }
    }

    public class MyReleaseViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recycler_hot_showing;

        public MyReleaseViewHolder(@NonNull View itemView) {
            super(itemView);
            recycler_hot_showing = itemView.findViewById(R.id.movie_zzyy);
        }
    }

    public class MyComingHolder extends RecyclerView.ViewHolder {
        private RecyclerView recycler_coming_soon;

        public MyComingHolder(@NonNull View itemView) {
            super(itemView);
            recycler_coming_soon = itemView.findViewById(R.id.movie_jjsy);
        }
    }

    public class MyMovieHolder extends RecyclerView.ViewHolder {
        private RecyclerView recycler_hot_movie;

        public MyMovieHolder(@NonNull View itemView) {
            super(itemView);
            recycler_hot_movie = itemView.findViewById(R.id.movie_rmdy);
        }
    }
    public interface OnckieButnk{
        void Onckedfklf1(int movieId);
    }
    private CominAdapter.OnckieButnk OnckieButnk;

    public void setOnckieButnkdd(CominAdapter.OnckieButnk onckieButnk) {
        OnckieButnk = onckieButnk;
    }
}
