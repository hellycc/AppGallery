package com.castro.helena.app.appgallery.helena.domain.usecase.datadetail;

import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataDetailDto;

import io.reactivex.rxjava3.core.Observable;

public interface GetDataDetailUseCase {
    Observable<DataDetailDto> invoke();
}
