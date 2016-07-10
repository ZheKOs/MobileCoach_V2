package io.github.zhekos.mobilecoach_v2.adapters;


import io.github.zhekos.mobilecoach_v2.R;

public enum FragmentPagerItemEnum {

    WORKOUTS(R.string.workout, R.layout.fragment_workout),
    NUTRITION(R.string.nutrition, R.layout.fragment_nutrition),
    STATS(R.string.stats, R.layout.fragmnet_stats);

    private int mTitleResId;
    private int mLayoutResId;

    FragmentPagerItemEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
