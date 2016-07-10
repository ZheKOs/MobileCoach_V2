package io.github.zhekos.mobilecoach_v2.adapters;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPagerItemAdapter extends PagerAdapter {

    private Context mContext;

    public FragmentPagerItemAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        FragmentPagerItemEnum fragmentPagerItemEnum = FragmentPagerItemEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(fragmentPagerItemEnum.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return FragmentPagerItemEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        FragmentPagerItemEnum fragmentPagerItemEnum = FragmentPagerItemEnum.values()[position];
        return mContext.getString(fragmentPagerItemEnum.getTitleResId());
    }

}