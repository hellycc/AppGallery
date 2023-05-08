package com.castro.helena.app.appgallery.helena.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.Nullable;

public class Tag implements Serializable {

    @Nullable
    @SerializedName("description")
    String tagDescription;

    @SerializedName("display_name")
    String displayName;

    @Nullable
    @SerializedName("followers")
    Integer followers;

    public Tag() {
    }

    public Tag(@Nullable String tagDescription, String displayName, @Nullable Integer followers) {
        this.tagDescription = tagDescription;
        this.displayName = displayName;
        this.followers = followers;
    }

    @Nullable
    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(@Nullable String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Nullable
    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(@Nullable Integer followers) {
        this.followers = followers;
    }

}
