package com.glu.wxApp.domain;

public class MedicinePlan {
    private int userId = -1;

    private String name;

    private String dasage;

    private int time = -1;

    private int weekFre = -1;

    private int dayFre = -1;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDasage() {
        return dasage;
    }

    public void setDasage(String dasage) {
        this.dasage = dasage;
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
