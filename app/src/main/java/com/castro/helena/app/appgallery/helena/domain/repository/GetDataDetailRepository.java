package com.castro.helena.app.appgallery.helena.domain.repository;


import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataDetailDto;

import io.reactivex.rxjava3.core.Observable;

public interface GetDataDetailRepository {

    Observable<DataDetailDto> getImageDetail(DataAggDto dataAggDto);
}
