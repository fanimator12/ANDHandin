package com.example.initialapp.Domain;

import java.util.ArrayList;
import java.util.List;

public class GoalResponse {
    private boolean resultsTruncated;
    private List<Goal> goals;
    private String version;
    private String status;

    public boolean getResultsTruncated() {
        return resultsTruncated;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public List<String> getGoalsLabels() {
        List<String> goalLabels = new ArrayList<>();
        for (int i = 0; i < goals.size(); i++) {
            goals.get(i).getGoalLabel();
            goalLabels.add(goals.get(i).getGoalLabel());
        }
        return goalLabels;
    }

    public String getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }

    public void setResultsTruncated(boolean resultsTruncated) {
        this.resultsTruncated = resultsTruncated;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
