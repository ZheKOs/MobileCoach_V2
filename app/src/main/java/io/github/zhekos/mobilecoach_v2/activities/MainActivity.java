package io.github.zhekos.mobilecoach_v2.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.adapters.PagerAdapter;
import io.github.zhekos.mobilecoach_v2.db.DBHelper;

import io.github.zhekos.mobilecoach_v2.db.WorkoutPlan;
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

        initToolbar();

        PagerAdapter adapter = new PagerAdapter(context, getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        prepareDB(); //call method to prepare db for work

    }


    private void prepareDB(){
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getDefaultInstance();

        //TESTIN PART
        testDB();
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/nrkis.ttf");

        mTitle.setTypeface(typeface);
        setSupportActionBar(toolbar);
    }

    private void testDB(){

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(WorkoutPlan.class);
            }
        });

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                WorkoutPlan wp = new WorkoutPlan();
                wp.setName("Test 1");
                realm.copyToRealmOrUpdate(wp);
                WorkoutPlan wp2 = new WorkoutPlan();
                wp2.setName("Test 2");
                realm.copyToRealmOrUpdate(wp2);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
