package com.example.skillsacademy.home.viewmodel;

import com.example.skillsacademy.home.pojo.Devolopment;
import com.example.skillsacademy.home.repository.DevelopmentRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DevelopmentViewModel extends ViewModel {
    public DevelopmentRepository developmentRepository;

    public DevelopmentViewModel() {
        this.developmentRepository=new DevelopmentRepository();
    }

    public LiveData<List<Devolopment>> getCourse(){
        return developmentRepository.getCourses();
    }
}
