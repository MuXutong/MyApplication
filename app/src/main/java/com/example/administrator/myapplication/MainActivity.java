package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.myapplication.fragment.FragmentCtrl;
import com.example.administrator.myapplication.fragment.FragmentFind;
import com.example.administrator.myapplication.fragment.FragmentHome;
import com.example.administrator.myapplication.fragment.FragmentMine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String mTitleArray[] = {"首页", "发现", "智控", "我的"};
    private int mImageViewArray[] = {R.drawable.icon_home, R.drawable.icon_find, R.drawable.icon_ctrl, R.drawable.icon_mine};

    private BottomNavigationBar mBottomNavigationBar;

    private List<Fragment> allFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBottomNavigationBar();

        setDefaultFragment();



    }
    private void setDefaultFragment() {

        allFragments=new ArrayList<>();
        allFragments.add(new FragmentHome());
        allFragments.add(new FragmentFind());
        allFragments.add(new FragmentCtrl());
        allFragments.add(new FragmentMine());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frameLayout,allFragments.get(0));
        transaction.commit();
    }
    private void setBottomNavigationBar() {

        mBottomNavigationBar = findViewById(R.id.bottom_navigation_bar);

        mBottomNavigationBar//设置模式
                .setMode(BottomNavigationBar.MODE_FIXED)
                //设置背景颜色
                .setBarBackgroundColor(R.color.white)
                //设置每个item的颜色
                .setInActiveColor(R.color.black)
                .setActiveColor(R.color.blue)
                //
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                //
                .addItem(new BottomNavigationItem(mImageViewArray[0], mTitleArray[0]))
                .addItem(new BottomNavigationItem(mImageViewArray[1], mTitleArray[1]))
                .addItem(new BottomNavigationItem(mImageViewArray[2], mTitleArray[2]))
                .addItem(new BottomNavigationItem(mImageViewArray[3], mTitleArray[3]))
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                //未选中->选中
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frameLayout,allFragments.get(position));
                transaction.commit();

            }
            @Override
            public void onTabUnselected(int position) {
                //选中->未选中
            }
            @Override
            public void onTabReselected(int position) {
                //选中->选中
            }
        });

    }

}
