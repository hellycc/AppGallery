package com.castro.helena.app.appgallery.helena.domain.repository;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;

import io.reactivex.rxjava3.core.Observable;

public interface GetDataAggRepository {
    Observable<Resource<DataAggDto>> getGalleryImages(String query);
}
