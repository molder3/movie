package com.bw.movie.view.activity;

import androidx.annotation.NonNull;
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
import com.bw.movie.view.fragment.TickFragmentone;
import com.bw.movie.view.fragment.TickFragmenttwo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TicketRecordActivity extends AppCompatActivity {
    private TabLayout buy_tab_la;
    private ViewPager buy_view_page;
    private List<String> mTlist;
    private List<Fragment> mFlist;
    private ImageView details_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_record);
        buy_view_page=findViewById(R.id.buy_view_page);
        buy_tab_la=findViewById(R.id.buy_tab_la);
        details_back=findViewById(R.id.details_back);
        mTlist=new ArrayList<>();
        mTlist.add("待付款");
        mTlist.add("已付款");
        mFlist=new ArrayList<>();
        mFlist.add(new TickFragmentone());
        mFlist.add(new TickFragmenttwo());
        buy_view_page.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFlist.get(position);
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
        buy_tab_la.setupWithViewPager(buy_view_page);
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
