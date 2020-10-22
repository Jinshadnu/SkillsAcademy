package com.example.skillsacademy.home.viewmodel;

import com.example.skillsacademy.home.pojo.Featured;
import com.example.skillsacademy.home.repository.FeaturedRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class FeaturedViewModel extends ViewModel {
public FeaturedRepository featuredRepository;
    public FeaturedViewModel() {
        this.featuredRepository=new FeaturedRepository();
    }

    public LiveData<List<Featured>> getFeaturedVideos(){
        return featuredRepository.getFeaturedVideos();
    }
}
