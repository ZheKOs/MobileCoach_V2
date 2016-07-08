package io.github.zhekos.mobilecoach_v2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.zhekos.mobilecoach_v2.activities.MainActivity;
import io.github.zhekos.mobilecoach_v2.R;

//TODO: StatsFragment
public class StatsFragment extends Fragment {

    MainActivity mainActivity;
    LayoutInflater mInflater;
    ViewGroup mContainer;

    View mView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        mInflater = inflater;
        mContainer = container;

        mView = mInflater.inflate(R.layout.fragmnet_stats, mContainer, false);

        return mView;
    }
}
