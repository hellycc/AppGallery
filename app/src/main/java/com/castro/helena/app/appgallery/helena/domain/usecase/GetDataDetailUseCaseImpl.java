package com.castro.helena.app.appgallery.helena.domain.usecase;

import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataDetailRepository;

import javax.inject.Inject;

public class GetDataDetailUseCaseImpl implements GetDataDetailUseCase {

    final GetDataDetailRepository repository;

    DataAgg dataAgg;

    @Inject
    public GetDataDetailUseCaseImpl(GetDataDetailRepository repository, DataAgg dataAgg) {
        this.repository = repository;
        this.dataAgg = dataAgg;
    }

    @Override
    public DataDetail buildGetDataDetailUseCase() {
        return repository.getImageDetail();
    }

    public DataDetail execute() {
         return buildGetDataDetailUseCase();
    }


}
