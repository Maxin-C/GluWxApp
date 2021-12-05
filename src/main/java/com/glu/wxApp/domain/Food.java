package com.glu.wxApp.domain;

public class Food {
    private String name;

    private int type = -1;

    private float energy = -1;

    private float protein = -1;

    private float fat = -1;

    private float cho = -1;

    private float na = -1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
}
