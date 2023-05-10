package com.castro.helena.app.appgallery.helena.domain.repository;


import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;

public interface GetDataDetailRepository {

    DataDetail getImageDetail(DataAggDto dataAggDto);
}
