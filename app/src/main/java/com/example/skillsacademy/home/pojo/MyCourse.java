package com.example.skillsacademy.home.pojo;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class MyCourse {
    public int course_id;
    public String course_name;
    public String tutor_name;
    public int course_image;

    public MyCourse(String course_name, String tutor_name, int course_image) {
        this.course_name = course_name;
        this.tutor_name = tutor_name;
        this.course_image = course_image;
    }




    public int getCourse_image() {
        return course_image;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getTutor_name() {
        return tutor_name;
    }


    @BindingAdapter("mycource")
    public static void  loadImage(ImageView imageView, int image){
        imageView.setImageResource(image);
    }







}
