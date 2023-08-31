package com.example.constitution_of_india.Roomdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class PojoOne implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;


    private String title;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PojoOne(int id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }
}
