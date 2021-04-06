package com.example.foodx.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodx.CategoryActivity;
import com.example.foodx.MainActivity;
import com.example.foodx.R;
import com.example.foodx.models.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryViewHolder> {

    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.listitem_category,parent,false);
        return new categoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.categoryTitle.setText(category.getStrCategory());
        Glide.with(context).load(category.getStrCategoryThumb()).placeholder(R.drawable.ic_launcher_background).into(holder.categoryImg);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CategoryActivity.class);
            intent.putExtra(MainActivity.KEY_CATEGORY_NAME,category.getStrCategory());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImg;
        TextView categoryTitle;
        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImg = itemView.findViewById(R.id.categoryImg);
            categoryTitle = itemView.findViewById(R.id.categoryTitle);
        }
    }


}
