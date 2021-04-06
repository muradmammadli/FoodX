package com.example.foodx.api;

import com.example.foodx.models.CategoryList;
import com.example.foodx.models.MealList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v2/1/latest.php/")
    Call<MealList> getMeals();

    @GET("v1/1/categories.php")
    Call<CategoryList> getCategories();

}
