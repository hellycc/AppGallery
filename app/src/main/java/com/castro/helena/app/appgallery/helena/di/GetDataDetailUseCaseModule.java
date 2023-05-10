package com.castro.helena.app.appgallery.helena.di;


import com.castro.helena.app.appgallery.helena.domain.usecase.GetDataDetailUseCase;
import com.castro.helena.app.appgallery.helena.domain.usecase.GetDataDetailUseCaseImpl;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class GetDataDetailUseCaseModule {

    @Binds
    @Singleton
    abstract GetDataDetailUseCase bindGetDataDetailUseCase(GetDataDetailUseCaseImpl dataDetailUseCaseImpl);

}
