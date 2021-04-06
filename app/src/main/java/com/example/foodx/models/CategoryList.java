package com.example.foodx.models;

import com.example.foodx.models.Category;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryList {
    @SerializedName("categories")

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
