package io.github.zhekos.mobilecoach_v2.db;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Exercise extends RealmObject {

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


}
