package com.dhm.uniontestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Main Activity";

    // Create object of ViewPager2
    private ViewPager2 viewPager2;

    //Tab layout
    private TabLayout tabLayout;

    //Fragment Adapter
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager_2);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm,getLifecycle());

        viewPager2.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("Home").setIcon(R.drawable.outline_home_24));
        tabLayout.addTab(tabLayout.newTab().setText("Challenges").setIcon(R.drawable.outline_article_24));
        tabLayout.addTab(tabLayout.newTab().setText("Rewards").setIcon(R.drawable.outline_emoji_events_24));
        tabLayout.addTab(tabLayout.newTab().setText("Leaderboard").setIcon(R.drawable.outline_leaderboard_24));
        tabLayout.addTab(tabLayout.newTab().setText("Profile").setIcon(R.drawable.outline_person_24));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    private void initRecyclerView() {

    }

}