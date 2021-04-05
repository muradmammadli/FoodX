package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 pager;
    private ApiInterface apiInterface;
    private PagerAdapter pagerAdapter;
    private RecyclerView recyclerViewBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();

        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<MealList> call = apiInterface.getMeals();

        call.enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.isSuccessful()) {
                    setPagerAdapter(response);
                }
            }
            @Override
            public void onFailure(Call<MealList> call, Throwable t) {
                Log.d("Error on pager", t.getMessage());
            }
        });

    }

    public void initializeVariables() {
        pager = findViewById(R.id.viewPagerHeader);
        recyclerViewBottom = findViewById(R.id.recyclerViewBottom);
    }

    public void setPagerAdapter( Response<MealList> response){
        pager.setClipToPadding(false);
        pager.setClipChildren(false);
        pager.setOffscreenPageLimit(3);
        pager.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        List<Meals> mealList = response.body().getMealsList();
        pagerAdapter = new PagerAdapter(MainActivity.this,mealList);
        pager.setAdapter(pagerAdapter);
    }
}