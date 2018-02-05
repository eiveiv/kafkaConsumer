package com.example.demo.model;

public class GoalUpdate {

    private String team;
    private String playername;
    private int goals;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "GoalUpdate{" +
                "team='" + team + '\'' +
                ", playername='" + playername + '\'' +
                ", goals=" + goals +
                '}';
    }
}

