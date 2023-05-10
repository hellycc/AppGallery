package com.castro.helena.app.appgallery.helena.di;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.usecase.GetDataAggUseCase;
import com.castro.helena.app.appgallery.helena.domain.usecase.GetDataAggUseCaseImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class GetDataAggUseCaseModule {

    @Binds
    @Singleton
    abstract GetDataAggUseCase<Resource<DataAggDto>> bindGetDataAggUseCase(GetDataAggUseCaseImpl dataAggUseCaseImpl);

}
