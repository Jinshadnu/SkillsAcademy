package com.example.skillsacademy.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.skillsacademy.home.pojo.MyCourse;
import com.example.skillsacademy.home.repository.MycourseRepository;

import java.util.List;

public class MyCourseViewModel extends ViewModel {
    public MycourseRepository mycourseRepository;

    public MyCourseViewModel() {
         this.mycourseRepository=new MycourseRepository();
    }

    public LiveData<List<MyCourse>> getCourse(){
        return mycourseRepository.getCourse();
    }
}
