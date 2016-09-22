package com.yundian.tableviewpagerlib;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cookie on 2016/8/29.
 */
public class TableViewPager extends LinearLayout {

    private Context context;
    private LinearLayout mLinearLayout;
    private ViewPager mViewPager;
    private ImageView mImageViewLeft, mImageViewMiddle, mImageViewRight;

    private int all = 0;

    private int mColorText = Color.GRAY;
    private float mSizeText = 15;

    public TableViewPager(Context context) {
        this(context, null);
    }

    public TableViewPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TableViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_tableviewpager, this);

        mViewPager = (ViewPager) findViewById(R.id.vp_layout_tableviewpager);
        mLinearLayout = (LinearLayout) findViewById(R.id.ll_layout_tableviewpager);
        mImageViewLeft = (ImageView) findViewById(R.id.iv_activity_coupons_left);
        mImageViewMiddle = (ImageView) findViewById(R.id.iv_activity_coupons_mid);
        mImageViewRight = (ImageView) findViewById(R.id.iv_activity_coupons_right);

        setEventListener();
    }

    private void setEventListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setTablePosition(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setTablePosition(int position, float positionOffset) {
        mImageViewLeft.setLayoutParams(new LinearLayout.LayoutParams(0, 0, position + positionOffset));
        mImageViewRight.setLayoutParams(new LinearLayout.LayoutParams(0, 0, all - position - positionOffset));
    }

    public void setTable(List<String> list) {
        all = list.size() - 1;
        LayoutParams layoutParams = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            final TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextColor(mColorText);
            textView.setTextSize(mSizeText);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);
            textView.setTag(i);

            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setCurrentItem((Integer) textView.getTag());
                }
            });
            mLinearLayout.addView(textView);
        }
    }

    public void setTableTextColor(int color) {
        mColorText = color;
    }

    public void setTableTextColor(int... color) {
        for (int i = 0; i < mLinearLayout.getChildCount(); i++){
            TextView tv = (TextView) mLinearLayout.getChildAt(i);
            tv.setTextColor(color[i]);
        }
    }

    public void setTableTextSize(float size){
        mSizeText = size;
    }

    public void setTableBackgroundColor(int color) {
        mLinearLayout.setBackgroundColor(color);
    }

    public void setTableBarckgroundColor(int... color){
        for (int i = 0; i < mLinearLayout.getChildCount(); i++){
            mLinearLayout.getChildAt(i).setBackgroundColor(color[i]);
        }
    }

    public void setTableBarColor(int color){
        mImageViewMiddle.setColorFilter(color);
    }

    public void setTableHeight(int height){
        mLinearLayout.getLayoutParams().height = height;
    }

    public void setAdapter(PagerAdapter adapter) {
        mViewPager.setAdapter(adapter);
    }

    public void addOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        mViewPager.addOnPageChangeListener(listener);
    }

    public void setCurrentItem(int item) {
        mViewPager.setCurrentItem(item);
    }
}
