package io.github.zhekos.mobilecoach_v2.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.db.NutritionPlan;
import io.github.zhekos.mobilecoach_v2.db.WorkoutPlan;
import io.github.zhekos.mobilecoach_v2.fragments.NutritionFragment;
import io.github.zhekos.mobilecoach_v2.fragments.StatsFragment;
import io.github.zhekos.mobilecoach_v2.fragments.WorkoutFragment;


public class PagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    Context context;

    public PagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return WorkoutFragment.newInstance();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return NutritionFragment.newInstance();
            case 2: // Fragment # 1 - This will show SecondFragment
                return StatsFragment.newInstance();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        String str = "";
        switch (position){
            case 0:
                str = context.getString(R.string.workout);
                break;
            case 1:
                str = context.getString(R.string.nutrition);
                break;
            case 2:
                str = context.getString(R.string.stats);
                break;
        }
        return str;
    }

}