package io.github.zhekos.mobilecoach_v2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.github.zhekos.mobilecoach_v2.activities.MainActivity;
import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.db.Dish;

//TODO: NutritionFragment
public class NutritionFragment extends Fragment {

    public static final String ARG_DISHES = "dishes";
    private static ArrayList<Dish> dishes;

    MainActivity mainActivity;
    LayoutInflater mInflater;
    ViewGroup mContainer;

    View mView;

    public static NutritionFragment newInstance() {
        NutritionFragment fragment = new NutritionFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DISHES, dishes);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        mInflater = inflater;
        mContainer = container;

        mView = mInflater.inflate(R.layout.fragment_nutrition, mContainer, false);

        return mView;
    }

}
