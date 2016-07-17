package io.github.zhekos.mobilecoach_v2.db;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class WorkoutPlan extends RealmObject implements Parcelable{

    @PrimaryKey
    private long id;
    private String name;
    private RealmList<Workout> workouts;

    //TODO: Constructors WorkoutPlan
    public WorkoutPlan(){
        this.id = RealmAutoIncrement.getInstance(this.getClass()).getNextIdFromModel();
    }



    //Getters and setters

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public RealmList<Workout> getWorkouts() {return workouts;}
    public void setWorkouts(RealmList<Workout> workouts) {this.workouts = workouts;}



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
    public static final Parcelable.Creator<WorkoutPlan> CREATOR = new Parcelable.Creator<WorkoutPlan>() {
        public WorkoutPlan createFromParcel(Parcel in) {
            return new WorkoutPlan(in);
        }

        public WorkoutPlan[] newArray(int size) {
            return new WorkoutPlan[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private WorkoutPlan(Parcel in) {
        setId(in.readLong());
        setName(in.readString());
    }

}
