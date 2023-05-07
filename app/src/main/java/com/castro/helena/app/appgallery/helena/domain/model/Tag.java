package com.castro.helena.app.appgallery.helena.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tag implements Serializable {

    @SerializedName("description")
    String tagDescription;

    @SerializedName("display_name")
    String displayName;

    @SerializedName("followers")
    Integer followers;

    public Tag() {
    }

    public Tag(String tagDescription, String displayName, Integer followers) {
        this.tagDescription = tagDescription;
        this.displayName = displayName;
        this.followers = followers;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

}
