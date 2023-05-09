package com.castro.helena.app.appgallery.helena.domain.model;

import androidx.annotation.Nullable;

import com.castro.helena.app.appgallery.helena.data.remote.dto.DataDetailDto;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class DataDetail implements Serializable {

    String title;

    @Nullable
    String description;

    String imageUrl;

    @Nullable
    List<Tag> tags;

    List<Image> images;

    @Nullable
    String error;

    @Inject
    public DataDetail() {
    }

    public DataDetail(String title, @Nullable String description, String imageUrl, @Nullable List<Tag> tags, List<Image> images, @Nullable String error) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.images = images;
        this.error = error;
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
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Nullable
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(@Nullable List<Tag> tags) {
        this.tags = tags;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Nullable
    public String getError() {
        return error;
    }

    public void setError(@Nullable String error) {
        this.error = error;
    }

    public DataDetailDto toDto(DataDetail entity) {
        DataDetailDto dto = new DataDetailDto();
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setLink(entity.getImageUrl());
        dto.setTags(entity.getTags());
        dto.setImages(entity.getImages());
        dto.setError(entity.getError());
        return dto;
    }

}
