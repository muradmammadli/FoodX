package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.foodx.adapters.MealsByCategoryAdapter;
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
    MealsByCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        initializeVariables();
        onSetCategoryAdapter();
    }

    public void onSetCategoryAdapter() {
        categoryRv.setLayoutManager(new LinearLayoutManager(this));
        categoryRv.setHasFixedSize(true);
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra(MainActivity.KEY_CATEGORY_NAME);
        Call<MealList> mealListCall = apiInterface.getMealByCategory(categoryName);
        Log.d("mealListCall", String.valueOf(mealListCall));
        mealListCall.enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.isSuccessful()) {
                    List<Meals> mealsList = response.body().getMealsList();
                    adapter = new MealsByCategoryAdapter(CategoryActivity.this, mealsList);
                    adapter.notifyDataSetChanged();
                    categoryRv.setAdapter(adapter);
                    Log.d("mealsList", String.valueOf(mealsList.size()));
                }
                Log.d("response", String.valueOf(response));

            }

            @Override
            public void onFailure(Call<MealList> call, Throwable t) {
            }
        });
    }


    public void initializeVariables() {
        categoryRv = findViewById(R.id.categoryRv);
    }
}