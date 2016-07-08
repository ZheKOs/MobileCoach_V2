package io.github.zhekos.mobilecoach_v2.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Nutrition extends RealmObject {

    @PrimaryKey
    private long id;
    private Dish dish;
    private long amount; //in gramms
    private boolean isGramms;



}
