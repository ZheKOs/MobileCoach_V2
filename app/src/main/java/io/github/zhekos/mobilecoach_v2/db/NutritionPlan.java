package io.github.zhekos.mobilecoach_v2.db;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class NutritionPlan extends RealmObject implements Parcelable{

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



    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Parcelable part

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeString(getName());
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<NutritionPlan> CREATOR = new Parcelable.Creator<NutritionPlan>() {
        public NutritionPlan createFromParcel(Parcel in) {
            return new NutritionPlan(in);
        }

        public NutritionPlan[] newArray(int size) {
            return new NutritionPlan[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private NutritionPlan(Parcel in) {
        setId(in.readLong());
        setName(in.readString());
    }

}
