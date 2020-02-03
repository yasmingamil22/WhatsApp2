package com.example.whatsapp;

public class ChatsView {
    private String name;
    private String mess;
    private String time;
    private int id;


    public ChatsView(String name, String mess, String time, int id) {
        this.name = name;
        this.mess = mess;
        this.time = time;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
