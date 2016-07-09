package io.github.zhekos.mobilecoach_v2.db;


import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Exercise extends RealmObject implements Parcelable{

    @PrimaryKey
    private long id;
    private String name;
    private String instruction;
    private String imgPath;

    //TODO: Constructors Exercise
    public Exercise(){}



    //Getters and setters

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getInstruction() {return instruction;}
    public void setInstruction(String instruction) {this.instruction = instruction;}

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
    public static final Parcelable.Creator<Exercise> CREATOR = new Parcelable.Creator<Exercise>() {
        public Exercise createFromParcel(Parcel in) {
            return new Exercise(in);
        }

        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Exercise(Parcel in) {
        setId(in.readLong());
        setName(in.readString());
    }


}
