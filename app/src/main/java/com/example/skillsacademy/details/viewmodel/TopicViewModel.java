package com.example.skillsacademy.details.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.skillsacademy.details.pojo.Topics;
import com.example.skillsacademy.details.repository.TopicRepository;

import java.util.List;

public class TopicViewModel extends ViewModel {

    public TopicRepository topicRepository;

    public TopicViewModel() {
        this.topicRepository=new TopicRepository();
    }

    public LiveData<List<Topics>> getTopics( ){
        return topicRepository.getTopics();
    }
}
