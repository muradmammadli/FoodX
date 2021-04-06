package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodx.api.ApiClient;
import com.example.foodx.api.ApiInterface;
import com.example.foodx.models.MealList;
import com.example.foodx.models.Meals;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRv;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initializeVariables();

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(MainActivity.KEY_CATEGORY_NAME);
        Call<MealList> mealListCall = apiInterface.getMealByCategory(categoryName);
        mealListCall.enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                List<Meals> mealsList = response.body().getMealsList();

            }

            @Override
            public void onFailure(Call<MealList> call, Throwable t) {

            }
        });


    }

    public void initializeVariables(){
        categoryRv = findViewById(R.id.categoryRv);
    }
}