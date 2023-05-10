package com.castro.helena.app.appgallery.helena.data.source.remote.dto;

import androidx.annotation.Nullable;

import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

public class DataAggDto implements Serializable {

    @Nullable
    @SerializedName("data")
    List<DataDetail> dataAgg;

    @SerializedName("success")
    Boolean success;

    @SerializedName("status")
    Integer statusCode;

    @Inject
    public DataAggDto() {
    }

    public DataAggDto(@Nullable List<DataDetail> dataAgg, Boolean success, Integer statusCode) {
        this.dataAgg = dataAgg;
        this.success = success;
        this.statusCode = statusCode;
    }

    @Nullable
    public List<DataDetail> getDataAgg() {
        return dataAgg;
    }

    public void setDataAgg(@Nullable List<DataDetail> dataAgg) {
        this.dataAgg = dataAgg;
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

    public DataAgg toEntity(DataAggDto dto) {
        DataAgg dataAgg = new DataAgg();
        dataAgg.setImageList(dto.getDataAgg());
        dataAgg.setSuccess(dto.getSuccess());
        dataAgg.setStatusCode(dto.getStatusCode());
        return dataAgg;
    }

}
