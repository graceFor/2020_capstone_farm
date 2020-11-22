package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class ManyItem {
    int image;
    String name;
    String time;
    int chat, good;

    public ManyItem(int image, String name, String time, int chat, int good){
        this.image = image;
        this.name = name;
        this.time = time;
        this.chat = chat;
        this.good=good;
    }

    public int getImage(){
        return image;
    }

    public String getName(){
        return name;
    }
    public String getTime(){
        return time;
    }

    public int getChat(){
        return chat;
    }
    public int getGood(){
        return good;
    }

    public void setChat(int chat) {
        this.chat = chat;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
