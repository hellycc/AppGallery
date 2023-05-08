package com.castro.helena.app.appgallery.helena.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.Nullable;

public class Image implements Serializable {

    @Nullable
    @SerializedName("description")
    String imageDescription;

    @SerializedName("type")
    String imageType;

    @SerializedName("link")
    String imageUrl;

    public Image() {
    }

    public Image(@androidx.annotation.Nullable String imageDescription, String imageType, String imageUrl) {
        this.imageDescription = imageDescription;
        this.imageType = imageType;
        this.imageUrl = imageUrl;
    }

    @Nullable
    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(@Nullable String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
