package io.github.zhekos.mobilecoach_v2.db;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class NutritionPlan extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private RealmList<Nutrition> nutritions;

    //TODO: Constructors NutritionPlan
    public NutritionPlan(){}



    //Getters and setters

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public RealmList<Nutrition> getNutritions() {return nutritions;}
    public void setNutritions(RealmList<Nutrition> nutritions) {this.nutritions = nutritions;}

}
