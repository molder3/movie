package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.BannerBean;
import com.bw.movie.model.bean.BeonBean;
import com.bw.movie.model.bean.ComingBean;
import com.bw.movie.model.bean.HotmovieBean;
import com.bw.movie.model.bean.MakeBean;
import com.bw.movie.present.BannerPresent;
import com.bw.movie.view.fragment.CominFragement;
import com.bw.movie.view.fragment.MovieFragment;
import com.bw.movie.view.fragment.MyFragement;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeasActivity<BannerPresent> implements ICountView.XBannerView {
    private RecyclerView movie_zzyy;
    private XBanner xBanner;
    private List<BannerBean.ResultBean> result;
    @Override
    protected int setLyout() {
        return R.layout.moviefr;
    }

    @Override
    protected void inttView() {
        movie_zzyy=findViewById(R.id.movie_zzyy);
        movie_zzyy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected BannerPresent Present() {
        return new BannerPresent();
    }

    @Override
    protected void inttData() {
        //轮播图
        present.xbanne();
        //热门电影
        present.moviehotrmsss();
        //即将上映
        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid",0);
        String ussisnid = jin.getString("ussisnid", "");
        present.moviecoming(ussid,ussisnid);
        present.moviehotrm();
    }

    @Override
    public void Sucess(BannerBean bean) {
        result = bean.getResult();
        //xbanner
     /*   for (int i = 0; i <result.size(); i++) {
            list.add(result.get(i).getImageUrl());
        }*/
        xBanner.setBannerData(R.layout.simpledraweeview, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int i) {
                return null;
            }

            @Override
            public int size() {
                return result.size();
            }
        });
        xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                String imageUrl = result.get(position).getImageUrl();
                SimpleDraweeView simpleDraweeView=view.findViewById(R.id.my_image_view);
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(imageUrl)
                        .setAutoPlayAnimations(true)
                        .build();
                simpleDraweeView.setController(controller);
            }
        });
    }

    @Override
    public void BeonSucess(BeonBean bean) {

    }

    @Override
    public void CominSucess(ComingBean bean) {

    }

    @Override
    public void HotMovieSucess(HotmovieBean bean) {

    }

    @Override
    public void MakkeSucess(MakeBean bean) {

    }
   /* private CustomScrollViewPager viewPager;
    private RadioGroup radioGroup;
    private MovieFragment movieFragment;
    private MyFragement myFragement;
    private CominFragement cominFragment;
    private List<Fragment> list;
    private RadioButton but1,but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.sh_view);
        radioGroup=findViewById(R.id.sh_group);
        but1=findViewById(R.id.sh_but1);
        but=findViewById(R.id.sh_but);
        movieFragment=new MovieFragment();
        myFragement=new MyFragement();
        cominFragment=new CominFragement();
        list=new ArrayList<>();
        list.add(movieFragment);
        list.add(myFragement);
        list.add(cominFragment);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        viewPager.setScrollable(false);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sh_but:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.sh_but1:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.sh_but2:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });

    }*/
}
