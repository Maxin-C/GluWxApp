package com.glu.wxApp.domain;

import java.util.Date;

public class FoodAnalysis {
    private int userId = -1;

    private Date date;

    private int mealType = -1;

    private float energy = -1;

    private float protein = -1;

    private float fat = -1;

    private float cho = -1;

    private float na = -1;

    private float vegetableFruit = -1;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMealType() {
        return mealType;
    }

    public void setMealType(int mealType) {
        this.mealType = mealType;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getCho() {
        return cho;
    }

    public void setCho(float cho) {
        this.cho = cho;
    }

    public float getNa() {
        return na;
    }

    public void setNa(float na) {
        this.na = na;
    }

    public float getVegetableFruit() {
        return vegetableFruit;
    }

    public void setVegetableFruit(float vegetableFruit) {
        this.vegetableFruit = vegetableFruit;
    }
}
