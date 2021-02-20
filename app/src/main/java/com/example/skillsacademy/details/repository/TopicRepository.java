package com.example.skillsacademy.details.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.skillsacademy.details.pojo.Topics;

import java.util.ArrayList;
import java.util.List;

public class TopicRepository {

    public TopicRepository() {
    }

 public LiveData<List<Topics>> getTopics(){
     MutableLiveData mutableLiveData=new MutableLiveData();
     List<Topics> topics=new ArrayList<>();
     topics.add(new Topics("Android Architecture"));
     topics.add(new Topics("Android Activity LifeCycle"));
     topics.add(new Topics("Android History"));
     topics.add(new Topics("Android Activity"));
     topics.add(new Topics("Core Builiding Blocks"));
     topics.add(new Topics("Android Service"));
     mutableLiveData.setValue(topics);
     return mutableLiveData;
 }
}
