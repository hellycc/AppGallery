package com.castro.helena.app.appgallery.helena.domain.usecase.dataagg;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataAggRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class GetDataAggUseCaseImpl implements GetDataAggUseCase {

    final GetDataAggRepository repository;

    @Inject
    public GetDataAggUseCaseImpl(GetDataAggRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Resource<DataAggDto>> invoke(String query) {
        return repository.getGalleryImages(query);
    }

}
