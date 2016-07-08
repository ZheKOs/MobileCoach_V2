package io.github.zhekos.mobilecoach_v2.db;

import android.content.Context;

import io.realm.Realm;

//TODO: DBHelper
public class DBHelper {

    private Context context;
    private Realm realm;

    public DBHelper(Context context, Realm realm){
        this.context = context;
        this.realm = realm;
    }

    //TODO: DBHelper methods

}
