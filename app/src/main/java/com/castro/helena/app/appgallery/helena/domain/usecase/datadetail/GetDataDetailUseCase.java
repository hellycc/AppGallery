package com.castro.helena.app.appgallery.helena.domain.usecase.datadetail;

import com.castro.helena.app.appgallery.helena.data.remote.dto.DataDetailDto;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import io.reactivex.rxjava3.core.Observable;

@Module
@InstallIn(FragmentComponent.class)
public interface GetDataDetailUseCase {
    @Binds // TODO: error: @Binds methods must have exactly one parameter, whose type is assignable to the return type
    // TODO: Observable<DataDetailDto> invoke();
    Observable<DataDetailDto> invoke();
}
