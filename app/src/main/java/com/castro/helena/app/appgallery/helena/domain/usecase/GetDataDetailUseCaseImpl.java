package com.castro.helena.app.appgallery.helena.domain.usecase;

import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataDetailRepository;

import javax.inject.Inject;

public class GetDataDetailUseCaseImpl implements GetDataDetailUseCase {

    final GetDataDetailRepository repository;

    @Inject
    public GetDataDetailUseCaseImpl(GetDataDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public DataDetail buildGetDataDetailUseCase(DataAggDto dataAggDto) {
        return repository.getImageDetail(dataAggDto);
    }

}
