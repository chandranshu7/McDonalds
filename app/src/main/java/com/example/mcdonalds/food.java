package com.example.mcdonalds;

public class food {

    private String foodTitle;
    private String rate;
    private String specs;
    private int image;

    public food(String foodTitle, String rate, String specs, int image) {
        this.foodTitle = foodTitle;
        this.rate = rate;
        this.specs = specs;
        this.image = image;
    }

    public food(String foodTitle, String rate, int image) {
        this.foodTitle = foodTitle;
        this.rate = rate;
        this.image = image;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public String getRate() {
        return rate;
    }

    public String getSpecs() {
        return specs;
    }

    public int getImage() {
        return image;
    }
}
