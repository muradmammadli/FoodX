package com.example.foodx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodx.R;
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
        View v = LayoutInflater.from(context).inflate(R.layout.listitem_meals_by_category,parent,false);
        return new mealsCategoryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull mealsCategoryHolder holder, int position) {
        Meals meal = mealsList.get(position);
        holder.mealName.setText(meal.getStrMeal());
        Glide.with(context).load(meal.getStrMealThumb()).placeholder(R.drawable.ic_launcher_foreground).into(holder.mealImage);
    }

    @Override
    public int getItemCount() {
        return mealsList.size();
    }

    public class mealsCategoryHolder extends RecyclerView.ViewHolder {
        TextView mealName;
        ImageView mealImage;
        public mealsCategoryHolder(@NonNull View itemView) {
            super(itemView);
            mealName = itemView.findViewById(R.id.meal_name);
            mealImage = itemView.findViewById(R.id.meal_image);
        }
    }


}
