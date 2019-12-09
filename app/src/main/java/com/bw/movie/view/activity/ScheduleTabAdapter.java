package com.bw.movie.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bw.movie.view.fragment.ScheduleTabFragment;

import java.util.List;

/**
 * date:2019/11/30
 * author:金豪(Lenovo)
 * function:
 */
public class ScheduleTabAdapter extends FragmentPagerAdapter {
    List<String> result;
    int did;
    public ScheduleTabAdapter(@NonNull FragmentManager fm, List<String> result, int did) {
        super(fm);
        this.result = result;
        this.did = did;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        bundle.putInt("did",did);
        ScheduleTabFragment scheduleTabFragment = new ScheduleTabFragment();
        scheduleTabFragment.setArguments(bundle);
        return scheduleTabFragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return result.get(position);
    }

    @Override
    public int getCount() {
        return result.size();
    }
}
