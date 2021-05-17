package com.example.initialapp.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bucketlist_goals")
public class BucketListGoals {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "user")
    private String user;
    @ColumnInfo(name = "goal")
    private String goal;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "location")
    private String location;
    @ColumnInfo (name = "imageID")
    private Integer imageID;
    @ColumnInfo (name = "description")
    private String description;
    @ColumnInfo (name = "completed")
    private Boolean isCompleted;


    public BucketListGoals(String user, String goal, String type, String location, Integer imageID, String description, Boolean isCompleted) {
        this.user = user;
        this.goal = goal;
        this.type = type;
        this.location = location;
        this.imageID = imageID;
        this.description = description;
        this.isCompleted = false;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}