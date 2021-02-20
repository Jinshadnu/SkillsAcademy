package com.example.skillsacademy.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.LayoutMycourceBinding;
import com.example.skillsacademy.home.pojo.Featured;
import com.example.skillsacademy.home.pojo.MyCourse;

import java.util.List;

import static android.view.LayoutInflater.from;

public class MyCourseAdapter extends RecyclerView.Adapter<MyCourseAdapter.CourseViewHolder> {
    public Context mContext;
    public List<MyCourse> courseList;

    public MyCourseAdapter(Context mContext, List<MyCourse> courseList) {
        this.mContext = mContext;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutMycourceBinding mycourceBinding= DataBindingUtil.inflate(from(mContext), R.layout.layout_mycource,parent,false);
        return new CourseViewHolder(mycourceBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        MyCourse myCourse=courseList.get(position);
        holder.mycourceBinding.setMycousre(myCourse);
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        public LayoutMycourceBinding mycourceBinding;

        public CourseViewHolder(@NonNull LayoutMycourceBinding layoutMycourceBinding) {
            super(layoutMycourceBinding.getRoot());
            this.mycourceBinding=layoutMycourceBinding;

        }
    }
}
