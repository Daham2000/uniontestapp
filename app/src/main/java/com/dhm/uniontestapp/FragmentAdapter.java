package com.dhm.uniontestapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {


    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1 :
                return new ChallengesFragment();
            case 2 :
                return new RewardsFragment();
            case 3:
                return new LeaderboardFragment();
            case 4:
                return new ProfileFragment();
        }

        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
