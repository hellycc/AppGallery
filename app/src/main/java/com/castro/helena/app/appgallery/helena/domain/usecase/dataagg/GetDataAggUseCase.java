package com.castro.helena.app.appgallery.helena.domain.usecase.dataagg;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import io.reactivex.rxjava3.core.Observable;

@Module
@InstallIn(FragmentComponent.class)
public interface GetDataAggUseCase {
    @Binds // TODO: error: @Binds methods' parameter type must be assignable to the return type
    // TODO: Observable<Resource<DataAggDto>> invoke(String query);
    Observable<Resource<DataAggDto>> invoke(String query);
}
