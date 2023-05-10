package com.castro.helena.app.appgallery.helena.domain.model;

import androidx.annotation.Nullable;

import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;

import java.io.Serializable;
import java.util.List;

public class DataAgg implements Serializable {

    @Nullable
    List<DataDetail> imageList;

    Boolean success;

    Integer statusCode;

    public DataAgg() {
    }

    public DataAgg(@Nullable List<DataDetail> imageList, Boolean success, Integer statusCode) {
        this.imageList = imageList;
        this.success = success;
        this.statusCode = statusCode;
    }

    @Nullable
    public List<DataDetail> getImageList() {
        return imageList;
    }

    public void setImageList(@Nullable List<DataDetail> imageList) {
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

    public DataAggDto toDto(DataAgg entity) {
        DataAggDto dto = new DataAggDto();
        dto.setDataAgg(entity.getImageList());
        dto.setSuccess(entity.getSuccess());
        dto.setStatusCode(entity.getStatusCode());
        return dto;
    }

}
