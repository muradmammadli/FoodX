package com.example.foodx.api;

import com.example.foodx.models.CategoryList;
import com.example.foodx.models.MealList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("v2/1/latest.php/")
    Call<MealList> getMeals();

    @GET("v1/1/categories.php")
    Call<CategoryList> getCategories();

    @GET("/v1/1/filter.php")
    Call<MealList> getMealByCategory(@Query("c") String categoryName);

}
