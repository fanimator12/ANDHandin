package com.example.initialapp.EventBusObjects;

import java.util.ArrayList;

public class GoalEvent {
    private String goalLabel;

    private String completedGoals;

    public void setGoalLabel(String label) {
        this.goalLabel = label;
    }

    public String getGoalLabel(){
        return goalLabel;
    }

    public String getCompletedGoals() {
        return completedGoals;
    }

    public void setCompletedGoals(String completedGoals) {
        this.completedGoals = completedGoals;
    }
}
