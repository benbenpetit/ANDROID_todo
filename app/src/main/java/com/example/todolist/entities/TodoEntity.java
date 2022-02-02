package com.example.todolist.entities;

import java.util.Date;

public class TodoEntity {

    private String title;
    private String description;
    private Date date;
    private boolean isChecked;

    public TodoEntity(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.isChecked = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean choice) {
        isChecked = choice;
    }

}
