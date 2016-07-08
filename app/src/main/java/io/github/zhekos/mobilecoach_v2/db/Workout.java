package io.github.zhekos.mobilecoach_v2.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Workout extends RealmObject {

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


}
