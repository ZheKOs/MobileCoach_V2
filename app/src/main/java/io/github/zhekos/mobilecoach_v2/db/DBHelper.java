package io.github.zhekos.mobilecoach_v2.db;

import android.content.Context;

import java.util.AbstractList;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

//TODO: DBHelper
public class DBHelper {

    //TODO: DBHelper methods


    //Do not call from UI thread! It can freeze UI for some time
    public static RealmResults<Exercise> getAllExercises(String sortField){
        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        if (sortField == null){
            return realm.where(Exercise.class).findAll();
        }
        return realm.where(Exercise.class).findAll().sort(sortField);
    }
    public static RealmResults getAll(Class className, String sortField){
        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        if (sortField == null){
            return realm.where(className).findAll();
        }
        return realm.where(className).findAll().sort(sortField);
    }

}
