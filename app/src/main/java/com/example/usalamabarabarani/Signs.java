package com.example.usalamabarabarani;

public class Signs {

    String title, description;
    int imageId;

    public Signs(String title, String description, int imageId) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }
}
