package com.example.skillsacademy.home.viewmodel;

import com.example.skillsacademy.home.pojo.Categories;
import com.example.skillsacademy.home.repository.CategoryRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CategoryViewModel extends ViewModel {
    public CategoryRepository categoryRepository;

    public CategoryViewModel() {
        this.categoryRepository=new CategoryRepository();
    }

    public LiveData<List<Categories>> getCatrgories(){
        return categoryRepository.fetchCategories();
    }
}
