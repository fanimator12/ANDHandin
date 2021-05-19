package com.example.initialapp.EventBusObjects;

public class GoalEvent {
    private String goalLabel;
    private String goalLocation;
    private String goalType;
    private Integer goalImage;

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

    public void setGoal(String label, String location, String type, Integer image) {
        this.goalLabel = label;
        this.goalLocation = location;
        this.goalType = type;
        this.goalImage = image;
    }
}
