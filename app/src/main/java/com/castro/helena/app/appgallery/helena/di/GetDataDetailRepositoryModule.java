package com.castro.helena.app.appgallery.helena.di;

import com.castro.helena.app.appgallery.helena.data.repository.GetDataDetailRepositoryImpl;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataDetailRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class GetDataDetailRepositoryModule {

    @Binds
    @Singleton
    abstract GetDataDetailRepository bindGetDataDetailRepository(GetDataDetailRepositoryImpl getDataDetailRepositoryImpl);
}
