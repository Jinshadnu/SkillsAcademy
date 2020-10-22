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
        featuredList.add(new Featured(R.drawable.bg,"Android Development","30"));
        featuredList.add(new Featured(R.drawable.bg,"SEO","45"));
        featuredList.add(new Featured(R.drawable.bg,"WEB Development","28"));

        mutableLiveData.setValue(featuredList);

        return mutableLiveData;
    }
}
