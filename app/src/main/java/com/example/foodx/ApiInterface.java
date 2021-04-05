package com.example.foodx;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("v2/1/latest.php/")
    Call<MealList> getMeals();

    @GET("v1/1/categories.php")
    Call<CategoryList> getCategories();

}
