package com.example.skillsacademy.home.repository;

import com.example.skillsacademy.home.pojo.Categories;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CategoryRepository {

    public CategoryRepository() {
    }

    public LiveData<List<Categories>> fetchCategories(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<Categories> categoriesList=new ArrayList<>();
        categoriesList.add(new Categories(100,"Development"));
        categoriesList.add(new Categories(100,"Buisness"));
        categoriesList.add(new Categories(100,"IT & Software"));
        categoriesList.add(new Categories(100,"Design"));
        categoriesList.add(new Categories(100,"Accounting"));
        categoriesList.add(new Categories(100,"Marketing"));

        mutableLiveData.setValue(categoriesList);

        return mutableLiveData;
    }
}
