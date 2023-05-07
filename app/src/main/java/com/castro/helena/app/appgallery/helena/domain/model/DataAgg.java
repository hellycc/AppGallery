package com.castro.helena.app.appgallery.helena.domain.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DataAgg implements Serializable {

    @SerializedName("data")
    List<DataDetail> imageList;

    @SerializedName("success")
    Boolean success;

    @SerializedName("status")
    Integer statusCode;

    public DataAgg() {
    }

    public DataAgg(List<DataDetail> imageList, Boolean success, Integer statusCode) {
        this.imageList = imageList;
        this.success = success;
        this.statusCode = statusCode;
    }

    public List<DataDetail> getImageList() {
        return imageList;
    }

    public void setImageList(List<DataDetail> imageList) {
        this.imageList = imageList;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}
