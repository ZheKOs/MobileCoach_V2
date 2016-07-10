package io.github.zhekos.mobilecoach_v2.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.adapters.FragmentPagerItemAdapter;
import io.github.zhekos.mobilecoach_v2.db.DBHelper;

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

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(context);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        prepareDB(); //call method to prepare db for work

    }


    private void prepareDB(){
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    private void initToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/nrkis.ttf");
        mTitle.setTypeface(typeface);
        setSupportActionBar(toolbar);
    }

}
