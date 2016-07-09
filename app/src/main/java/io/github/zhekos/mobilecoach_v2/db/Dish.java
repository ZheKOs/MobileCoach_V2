package io.github.zhekos.mobilecoach_v2.db;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Dish extends RealmObject implements Parcelable {

    @Ignore
    public static final String NO_IMG_PATH = "NIP!";

    @PrimaryKey
    private long id;
    private String name;
    private String recipe;
    private String imgPath;

    //TODO: Constructors Dish
    public Dish(){}



    //Getters and setters
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getRecipe() {return recipe;}
    public void setRecipe(String recipe) {this.recipe = recipe;}

    public String getImgPath() {return imgPath;}
    public void setImgPath(String imgPath) {this.imgPath = imgPath;}



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
    public static final Parcelable.Creator<Dish> CREATOR = new Parcelable.Creator<Dish>() {
        public Dish createFromParcel(Parcel in) {
            return new Dish(in);
        }

        public Dish[] newArray(int size) {
            return new Dish[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Dish(Parcel in) {
        setId(in.readLong());
        setName(in.readString());
    }

}
