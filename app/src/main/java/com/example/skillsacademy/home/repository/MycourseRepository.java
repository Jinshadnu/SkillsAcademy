package com.example.skillsacademy.home.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.skillsacademy.R;
import com.example.skillsacademy.home.pojo.MyCourse;

import java.util.ArrayList;
import java.util.List;

public class MycourseRepository {

    public MycourseRepository() {
    }

    public LiveData<List<MyCourse>> getCourse(){
        MutableLiveData mutableLiveData=new MutableLiveData();

        List<MyCourse> myCourses =new ArrayList<>();
        myCourses.add(new MyCourse("Android App Development","Jinshad", R.drawable.android_development));
        myCourses.add(new MyCourse("Web Development","Suhail", R.drawable.php_web_development));
        myCourses.add(new MyCourse("Android App Development","Jinshad", R.drawable.android_development));

        mutableLiveData.setValue(myCourses);
        return mutableLiveData;
    }
}
