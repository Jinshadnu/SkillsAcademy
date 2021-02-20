package com.example.skillsacademy.details.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.animation.content.Content;
import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.LayoutTopicBinding;
import com.example.skillsacademy.details.pojo.Topics;

import java.util.List;

import static android.view.LayoutInflater.from;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    public Context context;
    public List<Topics> topicsList;

    public TopicAdapter(Context context, List<Topics> topicsList) {
        this.context = context;
        this.topicsList = topicsList;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutTopicBinding topicBinding = DataBindingUtil.inflate(from(context), R.layout.layout_topic,parent,false);
        return new TopicViewHolder(topicBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
     Topics topics=topicsList.get(position);
     holder.topicBinding.setTopics(topics);
    }

    @Override
    public int getItemCount() {
        return topicsList.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
         public LayoutTopicBinding topicBinding;
        public TopicViewHolder(@NonNull LayoutTopicBinding layoutTopicBinding) {
            super(layoutTopicBinding.getRoot());
            this.topicBinding=layoutTopicBinding;

        }
    }
}


