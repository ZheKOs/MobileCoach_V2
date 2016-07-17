package io.github.zhekos.mobilecoach_v2.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.db.WorkoutPlan;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class WorkoutsAdapter extends RealmRecyclerViewAdapter<WorkoutPlan, WorkoutsAdapter.ViewHolder> {

    private Context context;
    private OrderedRealmCollection<WorkoutPlan> workouts;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView tv;
        AppCompatImageButton btn;

        WorkoutPlan wp;

        public ViewHolder(View v){
            super(v);

            tv = (AppCompatTextView) v.findViewById(R.id.row_tv_favorite_workout_name);
            btn = (AppCompatImageButton) v.findViewById(R.id.row_btn_favorite_workout_info);

        }
    }

    public WorkoutsAdapter(Context context, OrderedRealmCollection<WorkoutPlan> workouts, boolean autoUpdate){
        super(context, workouts, autoUpdate);
        this.context = context;
        this.workouts = workouts;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(context)
                .inflate(R.layout.row_favorite_workouts,parent, false);
        ViewHolder vh = new ViewHolder(rowView);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WorkoutPlan wp = getData().get(position);
        holder.tv.setText(wp.getName());

    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }


}
