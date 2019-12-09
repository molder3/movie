package com.bw.movie.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.view.fragment.AttentioncineFragement;
import com.bw.movie.view.fragment.AttentionmovieFragement;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AttentionActivity extends AppCompatActivity {
    private ImageView details_back;
    private TabLayout atten_tab_la;
    private ViewPager atten_view_page;
    private List<String> mTlist;
    private List<Fragment> mFlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        details_back=findViewById(R.id.details_back);
        atten_tab_la=findViewById(R.id.atten_tab_la);
        atten_view_page=findViewById(R.id.atten_view_page);

        mTlist=new ArrayList<>();
        mTlist.add("电影");
        mTlist.add("影院");
        mFlist=new ArrayList<>();
        mFlist.add(new AttentionmovieFragement());
        mFlist.add(new AttentioncineFragement());
        atten_view_page.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFlist.get(i);
            }

            @Override
            public int getCount() {
                return mFlist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTlist.get(position);
            }
        });
        atten_tab_la.setupWithViewPager(atten_view_page);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
