package com.example.skillsacademy.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.LayoutCategoriesBinding;
import com.example.skillsacademy.home.pojo.Categories;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;

public class CategoriesAdapater extends RecyclerView.Adapter<CategoriesAdapater.CategoryViewHolder> {
    public Context context;
    public List<Categories> categoriesList;
    public LayoutCategoriesBinding categoriesBinding;


    public CategoriesAdapater(Context context, List<Categories> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        categoriesBinding= DataBindingUtil.inflate(from(context), R.layout.layout_categories,parent,false);
        return new CategoryViewHolder(categoriesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Categories categories=categoriesList.get(position);
        holder.categoriesBinding.setCategories(categories);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        public LayoutCategoriesBinding categoriesBinding;
        public CategoryViewHolder(@NonNull LayoutCategoriesBinding categoriesBinding) {
            super(categoriesBinding.getRoot());
            this.categoriesBinding=categoriesBinding;

        }
    }
}
