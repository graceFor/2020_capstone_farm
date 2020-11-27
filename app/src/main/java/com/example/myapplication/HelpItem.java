package com.example.myapplication;

public class HelpItem {
    String name;
    String detail;
    String time;
    String title;
    int chat, good;

    public HelpItem(String name, String detail,String time,String title, int chat, int good){
        this.name = name;
        this.detail = detail;
        this.time = time;
        this.title =title;
        this.chat = chat;
        this.good=good;
    }

    public String getDetail() {
        return detail;
    }

    public String getTitle() {
        return title;
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


    public void setTime(String time) {
        this.time = time;
    }
}
