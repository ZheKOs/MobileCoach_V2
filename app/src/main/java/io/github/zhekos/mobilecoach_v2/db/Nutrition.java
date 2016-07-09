package io.github.zhekos.mobilecoach_v2.db;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Nutrition extends RealmObject implements Parcelable{

    @PrimaryKey
    private long id;
    private Dish dish;
    private long amount; //in gramms
    private boolean isGramms;

    public Nutrition(){}


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }
    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isGramms() {
        return isGramms;
    }
    public void setGramms(boolean gramms) {
        isGramms = gramms;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Parcelable part

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Nutrition> CREATOR = new Parcelable.Creator<Nutrition>() {
        public Nutrition createFromParcel(Parcel in) {
            return new Nutrition(in);
        }

        public Nutrition[] newArray(int size) {
            return new Nutrition[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Nutrition(Parcel in) {
        setId(in.readLong());
    }
}
