package com.glu.wxApp.domain;

public class GluPlan {
    private int userId = -1;

    private float target = -1;

    private int time = -1;

    private int weekFre = -1;

    private int dayFre = -1;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTarget() {
        return target;
    }

    public void setTarget(float target) {
        this.target = target;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getWeekFre() {
        return weekFre;
    }

    public void setWeekFre(int weekFre) {
        this.weekFre = weekFre;
    }

    public int getDayFre() {
        return dayFre;
    }

    public void setDayFre(int dayFre) {
        this.dayFre = dayFre;
    }
}
