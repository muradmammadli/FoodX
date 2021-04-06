package com.example.foodx.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meals {

    @SerializedName("idMeal")
    private String idMeal;

    @SerializedName("strMeal")
    @Expose
    private String strMeal;

    @SerializedName("strCategory")
    @Expose
    private String strCategory;

    @SerializedName("strArea")
    @Expose
    private String strArea;

    @SerializedName("strInstructions")
    @Expose
    private String strInstructions;

    @SerializedName("strMealThumb")
    @Expose
    private String strMealThumb;

    @SerializedName("strYoutube")
    @Expose
    private String strYoutube;


    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }
}
