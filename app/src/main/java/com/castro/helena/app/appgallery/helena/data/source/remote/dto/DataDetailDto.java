package com.castro.helena.app.appgallery.helena.data.source.remote.dto;

import androidx.annotation.Nullable;

import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.model.Image;
import com.castro.helena.app.appgallery.helena.domain.model.Tag;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class DataDetailDto implements Serializable {

    @SerializedName("title")
    String title;

    @Nullable
    @SerializedName("description")
    String description;

    @SerializedName("link")
    String link;

    @Nullable
    @SerializedName("tags")
    List<Tag> tags;

    @SerializedName("images")
    List<Image> images;

    @Nullable
    @SerializedName("error")
    String error;

    @Inject
    public DataDetailDto() {
    }

    public DataDetailDto(String title, @Nullable String description, String link, @Nullable List<Tag> tags, List<Image> images, @Nullable String error) {
        this.title = title;
        this.description = description;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public DataDetail toEntity(DataDetailDto dto) {
        DataDetail entity = new DataDetail();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getLink());
        entity.setTags(dto.getTags());
        entity.setImages(dto.getImages());
        entity.setError(dto.getError());
        return entity;
    }

}
