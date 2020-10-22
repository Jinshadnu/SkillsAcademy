package com.example.skillsacademy.home.pojo;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class Featured {
    public int image;
    public String course_name;
    public String lessons;

    public Featured(int image, String course_name, String lessons) {
        this.image = image;
        this.course_name = course_name;
        this.lessons = lessons;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getLessons() {
        return lessons;
    }

    public void setLessons(String lessons) {
        this.lessons = lessons;
    }

@BindingAdapter("featured")
public static void  loadImage(ImageView imageView, int image){
    imageView.setImageResource(image);
}


}
