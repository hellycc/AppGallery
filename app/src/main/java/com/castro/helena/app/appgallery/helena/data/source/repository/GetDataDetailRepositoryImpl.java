package com.castro.helena.app.appgallery.helena.data.source.repository;

import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataDetailRepository;

import javax.inject.Inject;


public class GetDataDetailRepositoryImpl implements GetDataDetailRepository {

    DataAgg dataAgg;

    @Inject
    public GetDataDetailRepositoryImpl(DataAgg dataAgg) {
        this.dataAgg = dataAgg;
    }

    @Override
    public DataDetail getImageDetail() {
        DataDetail detail = new DataDetail();
        if (dataAgg.getImageList() != null) {
            for (DataDetail d : dataAgg.getImageList()) {
                detail.setTitle(d.getTitle());
                detail.setDescription(d.getDescription());
                detail.setImageUrl(d.getImageUrl());
                detail.setTags(d.getTags());
                detail.setImages(d.getImages());
                detail.setError(d.getError());
            }
        }
        return detail;
    }

}
