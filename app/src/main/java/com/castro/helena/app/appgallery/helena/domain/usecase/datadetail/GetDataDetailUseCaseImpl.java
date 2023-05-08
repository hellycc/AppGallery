package com.castro.helena.app.appgallery.helena.domain.usecase.datadetail;

import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataDetailDto;
import com.castro.helena.app.appgallery.helena.domain.repository.GallerySearchRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class GetDataDetailUseCaseImpl implements GetDataDetailUseCase {

    @Inject
    GallerySearchRepository repository;

    @Inject
    DataAggDto dataAggDto;

    @Inject
    public GetDataDetailUseCaseImpl(GallerySearchRepository repository, DataAggDto dataAggDto) {
        this.repository = repository;
        this.dataAggDto = dataAggDto;
    }

    @Override
    public Observable<DataDetailDto> invoke() {
        return repository.getImageDetail(dataAggDto);
    }

}
