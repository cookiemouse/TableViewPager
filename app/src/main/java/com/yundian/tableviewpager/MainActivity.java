package com.yundian.tableviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yundian.tableviewpagerlib.TableViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TableViewPager mTableViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTableViewPager = (TableViewPager) findViewById(R.id.tvp);

        List<String> listTable = new ArrayList<>();
        List<Fragment> mFragmentList = new ArrayList<>();

        listTable.add("标题一");
        listTable.add("标题二");
        listTable.add("标题三");
        listTable.add("标题四");
        for (int i = 0; i < 4; i++) {
            mFragmentList.add(new TestFragment());
        }

        mTableViewPager.setTable(listTable);
        mTableViewPager.setAdapter(new GuideFragmentAdapter(getSupportFragmentManager(), mFragmentList));

        mTableViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
