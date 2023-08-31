package com.example.constitution_of_india.Pojos;

import com.google.gson.annotations.SerializedName;

public class Preamble {
    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("image")
    String image;

    @SerializedName("description")
    String description;


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

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

}
