package com.example.initialapp.EventBusObjects;

public class GoalEvent {
    private String goalLabel;
    private String goalLocation;

    public void setGoalLabel(String label) {
        this.goalLabel = label;
    }

    public String getGoal(){
        return goalLabel;
    }

    public void setGoalLocation(String location) {
        this.goalLocation = location;
    }

    public String getLocation(){
        return goalLocation;
    }
}
