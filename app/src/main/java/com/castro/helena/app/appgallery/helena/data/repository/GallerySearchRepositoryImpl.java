package com.castro.helena.app.appgallery.helena.data.repository;

import com.castro.helena.app.appgallery.helena.data.remote.GallerySearchApi;
import com.castro.helena.app.appgallery.helena.domain.repository.GallerySearchRepository;

import java.util.List;

public class GallerySearchRepositoryImpl implements GallerySearchRepository {

    public GallerySearchRepositoryImpl() {
    }

    public GallerySearchRepositoryImpl(GallerySearchApi api) {
    }

    @Override
    public List<String> getGalleryImages() {
        return null;
    }

}
