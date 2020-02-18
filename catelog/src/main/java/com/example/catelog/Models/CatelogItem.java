package com.example.catelog.Models;

public class CatelogItem {
    private int id;
    private String title;
    private String description;
    private int Rating;

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public CatelogItem(int id, String title, String description, int rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        Rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
