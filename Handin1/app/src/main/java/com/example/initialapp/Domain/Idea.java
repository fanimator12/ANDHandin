package com.example.initialapp.Domain;

public class Idea {

    private String idea;
    private int ideaIconID;

    public Idea(String idea, int ideaIconID) {
        this.idea = idea;
        this.ideaIconID = ideaIconID;
    }

    public String getIdea() {
        return idea;
    }

    public int getIdeaIconID(){
        return ideaIconID;
    }
}
