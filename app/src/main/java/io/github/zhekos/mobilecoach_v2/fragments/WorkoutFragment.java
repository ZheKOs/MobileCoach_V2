package io.github.zhekos.mobilecoach_v2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.github.zhekos.mobilecoach_v2.activities.MainActivity;
import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.adapters.WorkoutsAdapter;
import io.github.zhekos.mobilecoach_v2.db.WorkoutPlan;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

//TODO: WorkoutFragment
public class WorkoutFragment extends Fragment{

    MainActivity mainActivity;
    LayoutInflater mInflater;
    ViewGroup mContainer;

    Realm realm;

    View mView;

    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerView.Adapter adapter;

    public static WorkoutFragment newInstance(){
        WorkoutFragment workoutFragment = new WorkoutFragment();
//        Bundle args = new Bundle();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
//        workoutFragment.setArguments(args);
        return workoutFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        mInflater = inflater;
        mContainer = container;

        realm = Realm.getDefaultInstance();

        mView = mInflater.inflate(R.layout.fragment_workout, mContainer, false);

        rv = (RecyclerView) mView.findViewById(R.id.rv_favorite_workouts);

        RealmResults<WorkoutPlan> workoutsRes = realm.where(WorkoutPlan.class).findAllAsync();

        adapter = new WorkoutsAdapter(mainActivity, workoutsRes, true);
        rv.setAdapter(adapter);
        lm = new LinearLayoutManager(mainActivity);
        rv.setLayoutManager(lm);

        rv.setHasFixedSize(true);

        return mView;
    }
}
