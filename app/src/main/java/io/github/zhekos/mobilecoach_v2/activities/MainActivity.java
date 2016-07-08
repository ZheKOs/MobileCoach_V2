package io.github.zhekos.mobilecoach_v2.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import io.github.zhekos.mobilecoach_v2.R;
import io.github.zhekos.mobilecoach_v2.db.DBHelper;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        prepareDB(); //call method to prepare db for work


    }


    private void prepareDB(){
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(realmConfig);
        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        helper = new DBHelper(context,realm);
    }
}
