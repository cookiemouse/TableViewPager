package com.yundian.tableviewpager;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by cookie on 2016/6/29.
 */
public class GuideFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentArrayList;

    public GuideFragmentAdapter(FragmentManager fm, List<Fragment> mFragmentArrayList) {
        super(fm);
        this.mFragmentArrayList = mFragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }
}
