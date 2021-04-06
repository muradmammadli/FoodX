package com.example.foodx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodx.adapters.CategoryAdapter;
import com.example.foodx.adapters.PagerAdapter;
import com.example.foodx.api.ApiClient;
import com.example.foodx.api.ApiInterface;
import com.example.foodx.models.Category;
import com.example.foodx.models.CategoryList;
import com.example.foodx.models.MealList;
import com.example.foodx.models.Meals;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 pager;
    private ApiInterface apiInterface;
    private PagerAdapter pagerAdapter;
    private CategoryAdapter categoryAdapter;
    private RecyclerView recyclerViewBottom;
    private Timer timer;
    private int page = 1;
    public static final String KEY_CATEGORY_NAME = "categoryName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
        recyclerViewBottom.setLayoutManager(new GridLayoutManager(this, 3));
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        onCallViewPagerItems();
        onCallCategoryItems();
    }

    public void initializeVariables() {
        pager = findViewById(R.id.viewPagerHeader);
        recyclerViewBottom = findViewById(R.id.recyclerViewBottom);
    }

    public void onCallViewPagerItems() {
        Call<MealList> mealCall = apiInterface.getMeals();

        mealCall.enqueue(new Callback<MealList>() {
            @Override
            public void onResponse(Call<MealList> call, Response<MealList> response) {
                if (response.isSuccessful()) {
                    pager.setClipToPadding(false);
                    pager.setClipChildren(false);
                    pager.setOffscreenPageLimit(3);
                    pager.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
                    List<Meals> mealList = response.body().getMealsList();
                    pagerAdapter = new PagerAdapter(MainActivity.this, mealList);
                    pager.setAdapter(pagerAdapter);
                    pageSwitcher(3);
                }
            }

            @Override
            public void onFailure(Call<MealList> call, Throwable t) {
                Log.d("Error on pager", t.getMessage());
            }
        });
    }

    public void onCallCategoryItems() {
        Call<CategoryList> categoryCall = apiInterface.getCategories();
        categoryCall.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                List<Category> categoryList = response.body().getCategoryList();
                categoryAdapter = new CategoryAdapter(MainActivity.this, categoryList);
                recyclerViewBottom.setAdapter(categoryAdapter);
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
                Log.d("Error on category call", t.getMessage());
            }
        });
    }


    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
    }

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                public void run() {
                    pager.setCurrentItem(page++);
                }
            });
        }
    }
}