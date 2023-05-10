package com.castro.helena.app.appgallery.helena.domain.usecase.dataagg;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;

import io.reactivex.rxjava3.core.Observable;

public interface GetDataAggUseCase {
    Observable<Resource<DataAggDto>> invoke(String query);
}
