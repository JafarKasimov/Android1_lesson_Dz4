package com.example.android1_lesson_dz4;

import java.io.Serializable;

public class CatModel implements Serializable {
    private String statusCode;
    private String description;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CatModel(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }
}
