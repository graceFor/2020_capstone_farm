package com.example.myapplication;

public class GuideItem {
    int image;
    String name;

    public GuideItem(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
}
