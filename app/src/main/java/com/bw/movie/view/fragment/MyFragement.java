package com.bw.movie.view.fragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public class MyFragement extends BeasFragment {
    private ViewPager my_viewp;
    private TabLayout my_tab;
    private List<String> mTlist;
    private List<Fragment> mFlist;
    @Override
    protected int setLyout() {
        return R.layout.myfragement;
    }

    @Override
    protected void intiView() {
        my_tab = (TabLayout) getViewId(R.id.my_tab);
        my_viewp= (ViewPager) getViewId(R.id.my_viewp);
        mTlist=new ArrayList<>();
        mTlist.add("推荐影院");
        mTlist.add("附近影院");
        mTlist.add("海淀区");
        mFlist=new ArrayList<>();
        mFlist.add(new RecommendFragment());
        mFlist.add(new NearbyFragment());
        mFlist.add(new RegionFragment());
        my_viewp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
        my_tab.setupWithViewPager(my_viewp);
    }

    @Override
    protected BeasPresent setPrsent() {
        return new BeasPresent();
    }

    @Override
    protected void intiData() {

    }
}
