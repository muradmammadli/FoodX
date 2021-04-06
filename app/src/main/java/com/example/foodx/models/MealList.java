package com.example.foodx.models;

import com.example.foodx.models.Meals;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealList {
    @SerializedName("meals")
    @Expose
    private List<Meals> mealsList;

    public List<Meals> getMealsList() {
        return mealsList;
    }

    public void setMealsList(List<Meals> mealsList) {
        this.mealsList = mealsList;
    }
}
