package com.example.constitution_of_india.Pojos;

import com.google.gson.annotations.SerializedName;

public class NewsArticle {
    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("date")
    String date;

    @SerializedName("small_description")
    String smallDescription;


    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }
    public String getSmallDescription() {
        return smallDescription;
    }

}
