package com.castro.helena.app.appgallery.helena.di;

import com.castro.helena.app.appgallery.helena.domain.usecase.dataagg.GetDataAggUseCase;
import com.castro.helena.app.appgallery.helena.domain.usecase.dataagg.GetDataAggUseCaseImpl;

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
    abstract GetDataAggUseCase bindGetDataAggUseCase(GetDataAggUseCaseImpl dataAggUseCaseImpl);

}
