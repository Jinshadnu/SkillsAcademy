package com.example.skillsacademy.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.ActivityCourseDetailsBinding;
import com.example.skillsacademy.details.adapter.TopicAdapter;
import com.example.skillsacademy.details.pojo.Topics;
import com.example.skillsacademy.details.viewmodel.TopicViewModel;
import com.example.skillsacademy.home.viewmodel.TopSearchViewModel;

import java.util.List;

public class CourseDetailsActivity extends AppCompatActivity {
 public ActivityCourseDetailsBinding courseDetailsBinding;
 public TopicViewModel topicViewModel;
 public TopicAdapter topicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        courseDetailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_course_details);

        topicViewModel= ViewModelProviders.of(this).get(TopicViewModel.class);

        courseDetailsBinding.recyclerVideos.setLayoutManager(new LinearLayoutManager(this));
        courseDetailsBinding.recyclerVideos.setHasFixedSize(true);

        courseDetailsBinding.layoutBase.toolbar.setTitle("My Courses");

        courseDetailsBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        courseDetailsBinding.layoutBase.toolbar.setNavigationOnClickListener(v -> {
            this.onBackPressed();
        });

        getTopics();


    }

    private void getTopics() {
        topicViewModel.getTopics().observe((LifecycleOwner) this, new Observer<List<Topics>>() {
            @Override
            public void onChanged(List<Topics> topics) {
                topicAdapter=new TopicAdapter(CourseDetailsActivity.this,topics);
                courseDetailsBinding.recyclerVideos.setAdapter(topicAdapter);
            }
        });
    }
}