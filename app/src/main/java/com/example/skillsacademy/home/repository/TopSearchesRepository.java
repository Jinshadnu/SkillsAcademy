package com.example.skillsacademy.home.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.skillsacademy.home.pojo.TopSearches;

import java.util.ArrayList;
import java.util.List;

public class TopSearchesRepository {


    public TopSearchesRepository() {
    }

    public LiveData<List<TopSearches>> getCourse(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<TopSearches> searchesList=new ArrayList<>();
        searchesList.add(new TopSearches("PHP"));
        searchesList.add(new TopSearches("Android"));
        searchesList.add(new TopSearches("SEO"));
        searchesList.add(new TopSearches("PHP"));

        mutableLiveData.setValue(searchesList);
        return mutableLiveData;
    }

}
