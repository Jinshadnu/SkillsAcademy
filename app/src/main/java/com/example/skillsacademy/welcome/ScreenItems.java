package com.example.skillsacademy.welcome;

public class ScreenItems {
  public String title,description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int image;

    public ScreenItems(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }


}
