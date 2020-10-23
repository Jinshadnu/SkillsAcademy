package com.example.skillsacademy.home.repository;

import com.example.skillsacademy.R;
import com.example.skillsacademy.home.pojo.Devolopment;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DevelopmentRepository  {
    public DevelopmentRepository() {
    }

    public LiveData<List<Devolopment>> getCourses(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<Devolopment> devolopmentList=new ArrayList<>();
        devolopmentList.add(new Devolopment(R.drawable.android_development,"Android Development","1500","50 lesson"));
        devolopmentList.add(new Devolopment(R.drawable.digital_marketing,"WEB Development","1400","50 lesson"));
        devolopmentList.add(new Devolopment(R.drawable.android_development,"Digital Marketing","1800","50 lesson"));

        mutableLiveData.setValue(devolopmentList);
        return mutableLiveData;

    }
}
