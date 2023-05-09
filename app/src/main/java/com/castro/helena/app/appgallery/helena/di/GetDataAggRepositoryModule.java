package com.castro.helena.app.appgallery.helena.di;

import com.castro.helena.app.appgallery.helena.data.repository.GetDataAggRepositoryImpl;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataAggRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class GetDataAggRepositoryModule {

    @Binds
    @Singleton
    abstract GetDataAggRepository bindGetDataAggRepository(GetDataAggRepositoryImpl getDataAggRepositoryImpl);
}
