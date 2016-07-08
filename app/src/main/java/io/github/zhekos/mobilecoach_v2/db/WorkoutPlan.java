package io.github.zhekos.mobilecoach_v2.db;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WorkoutPlan extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private RealmList<Workout> workouts;

    //TODO: Constructors WorkoutPlan
    public WorkoutPlan(){}



    //Getters and setters

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public RealmList<Workout> getWorkouts() {return workouts;}
    public void setWorkouts(RealmList<Workout> workouts) {this.workouts = workouts;}

}
