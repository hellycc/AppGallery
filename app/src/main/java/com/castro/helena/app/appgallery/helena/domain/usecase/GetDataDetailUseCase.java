package com.castro.helena.app.appgallery.helena.domain.usecase;

import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;

public interface GetDataDetailUseCase {
    DataDetail buildGetDataDetailUseCase(DataAggDto dataAggDto);
}
