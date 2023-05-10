package com.castro.helena.app.appgallery.helena.di;

import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class DataAggModule {

    @Binds
    @Singleton
    abstract DataAgg bindDataAgg(DataAgg dataAgg);
}
