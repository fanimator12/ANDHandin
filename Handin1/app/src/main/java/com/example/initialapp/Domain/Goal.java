package com.example.initialapp.Domain;

public class Goal {

    private String goalLabel;
    private int goalIconID;

    public Goal(String goalLabel, int goalIconID) {
        this.goalLabel = goalLabel;
        this.goalIconID = goalIconID;
    }

    public String getGoalLabel() {
        return goalLabel;
    }

    public int getGoalIconID(){
        return goalIconID;
    }
}
