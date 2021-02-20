package com.example.skillsacademy.home.repository;

import com.example.skillsacademy.R;
import com.example.skillsacademy.home.pojo.Featured;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FeaturedRepository {

    public FeaturedRepository() {

    }

    public LiveData<List<Featured>> getFeaturedVideos(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<Featured> featuredList=new ArrayList<>();
        featuredList.add(new Featured(R.drawable.android_development,"Android Development","30 lesson"));
        featuredList.add(new Featured(R.drawable.seo,"SEO","45 lesson"));
        featuredList.add(new Featured(R.drawable.php_web_development,"WEB Development","28 lesson"));
        featuredList.add(new Featured(R.drawable.android_development,"IOS Development ","28 lesson"));

        mutableLiveData.setValue(featuredList);

        return mutableLiveData;
    }
}
