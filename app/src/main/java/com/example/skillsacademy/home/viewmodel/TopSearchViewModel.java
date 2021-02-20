package com.example.skillsacademy.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.skillsacademy.home.pojo.TopSearches;
import com.example.skillsacademy.home.repository.TopSearchesRepository;

import java.util.List;

public class TopSearchViewModel extends ViewModel {
    public TopSearchesRepository topSearchesRepository;

    public TopSearchViewModel() {
        this.topSearchesRepository=new TopSearchesRepository();
    }

    public LiveData<List<TopSearches>> getCourse(){
        return topSearchesRepository.getCourse();
    }
}
