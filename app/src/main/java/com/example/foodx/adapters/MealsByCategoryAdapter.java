package com.example.foodx.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodx.models.Meals;

import java.util.List;

public class MealsByCategoryAdapter extends RecyclerView.Adapter<MealsByCategoryAdapter.mealsCategoryHolder> {

    Context context;
    List<Meals> mealsList;

    public MealsByCategoryAdapter(Context context, List<Meals> mealsList) {
        this.context = context;
        this.mealsList = mealsList;
    }

    @NonNull
    @Override
    public mealsCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull mealsCategoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }

    public class mealsCategoryHolder extends RecyclerView.ViewHolder {
        public mealsCategoryHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
