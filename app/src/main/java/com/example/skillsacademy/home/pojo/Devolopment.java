package com.example.skillsacademy.home.pojo;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class Devolopment {
    public int course_image;
    public String course_name;
    public String price;
    public String lesson;

    public Devolopment(int course_image, String course_name, String price, String lesson) {
        this.course_image = course_image;
        this.course_name = course_name;
        this.price = price;
        this.lesson = lesson;
    }



    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }



    public int getCourse_image() {
        return course_image;
    }

    public void setCourse_image(int course_image) {
        this.course_image = course_image;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }





    @BindingAdapter("development")
    public static void loadImage(ImageView imageView, int image){
       imageView.setImageResource(image);
    }



}
