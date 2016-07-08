package io.github.zhekos.mobilecoach_v2.db;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class Dish extends RealmObject {

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
}
