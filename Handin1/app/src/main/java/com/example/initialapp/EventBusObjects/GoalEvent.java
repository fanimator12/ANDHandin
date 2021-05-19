package com.example.initialapp.EventBusObjects;

import java.util.ArrayList;

public class GoalEvent {
    private String goalLabel;
    private String goalLocation;
    private String goalType;
    private Integer goalImage;
    private ArrayList<String> goalAttributes;

    public String getType() {
        return goalType;
    }

    public void setType(String goalType) {
        this.goalType = goalType;
    }

    public Integer getImage() {
        return goalImage;
    }

    public void setImage(Integer goalImage) {
        this.goalImage = goalImage;
    }

    private String completedGoals;

    public void setGoalLabel(String label) {
        this.goalLabel = label;
    }

    public String getGoalLabel(){
        return goalLabel;
    }

    public void setGoalLocation(String location) {
        this.goalLocation = location;
    }

    public String getLocation(){
        return goalLocation;
    }

    public String getCompletedGoals() {
        return completedGoals;
    }

    public void setCompletedGoals(String completedGoals) {
        this.completedGoals = completedGoals;
    }

    public ArrayList<String> setGoalAttributes() {
        return goalAttributes;
    }
}
