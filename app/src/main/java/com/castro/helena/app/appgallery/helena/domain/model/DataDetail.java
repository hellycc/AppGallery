package com.castro.helena.app.appgallery.helena.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Nullable;

public class DataDetail implements Serializable {

    @SerializedName("title")
    String title;

    @Nullable
    @SerializedName("description")
    String description;

    @SerializedName("link")
    String dataImageUrl;

    @SerializedName("tags")
    List<Tag> tags;

    @SerializedName("images")
    List<Image> images;

    public DataDetail() {
    }

    public DataDetail(String title, @Nullable String description, String dataImageUrl, List<Tag> tags, List<Image> images) {
        this.title = title;
        this.description = description;
        this.dataImageUrl = dataImageUrl;
        this.tags = tags;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return dataImageUrl;
    }

    public void setImageUrl(String dataImageUrl) {
        this.dataImageUrl = dataImageUrl;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
