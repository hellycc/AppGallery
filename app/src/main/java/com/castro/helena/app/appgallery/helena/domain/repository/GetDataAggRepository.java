package com.castro.helena.app.appgallery.helena.domain.repository;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;

import io.reactivex.Single;


public interface GetDataAggRepository {
    Single<Resource<DataAggDto>> getGalleryImages(String query);
}
