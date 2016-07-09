package io.github.zhekos.mobilecoach_v2.db;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Workout extends RealmObject implements Parcelable{

    @PrimaryKey
    private long id;
    private Exercise exercise;
    private double weight;
    private long reps;
    private long rest; //time in msecs
    private String description;


    //TODO: Constructors Workout
    public Workout(){}

    //Getters and setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getReps() {
        return reps;
    }
    public void setReps(long reps) {
        this.reps = reps;
    }

    public long getRest() {
        return rest;
    }
    public void setRest(long rest) {
        this.rest = rest;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public static final Parcelable.Creator<Workout> CREATOR = new Parcelable.Creator<Workout>() {
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Workout(Parcel in) {
        setId(in.readLong());
    }

}
