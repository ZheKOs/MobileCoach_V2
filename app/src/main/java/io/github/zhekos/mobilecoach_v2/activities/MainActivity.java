package io.github.zhekos.mobilecoach_v2.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.db.DBHelper;
import io.github.zhekos.mobilecoach_v2.fragments.NutritionFragment;
import io.github.zhekos.mobilecoach_v2.fragments.StatsFragment;
import io.github.zhekos.mobilecoach_v2.fragments.WorkoutFragment;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "DEBUG_APP";
    public static final String PERF_FIRST = "is_first";
    public static final String isNull = "is null";

    private Context context;
    private DBHelper helper;

    Realm realm;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        //init Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView txt = (TextView) toolbar.findViewById(R.id.toolbar_title);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/nrkis.ttf");
        txt.setTypeface(font);
        setSupportActionBar(toolbar);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(context)
                .add(R.string.workout, WorkoutFragment.class)
                .add(R.string.nutrition, NutritionFragment.class)
                .add(R.string.stats, StatsFragment.class)
                .create()
        );

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        prepareDB(); //call method to prepare db for work

    }


    private void prepareDB(){
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(realmConfig);
    }

}
