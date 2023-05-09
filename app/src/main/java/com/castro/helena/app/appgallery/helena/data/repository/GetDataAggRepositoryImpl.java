package com.castro.helena.app.appgallery.helena.data.repository;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.remote.GallerySearchApi;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataAggRepository;


import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class GetDataAggRepositoryImpl implements GetDataAggRepository {

    GallerySearchApi api;

    @Inject
    public GetDataAggRepositoryImpl(GallerySearchApi api) {
        this.api = api;
    }

    @Override
    public Observable<Resource<DataAggDto>> getGalleryImages(String query) {
        return api.getGallerySearch(query);
    }

}
