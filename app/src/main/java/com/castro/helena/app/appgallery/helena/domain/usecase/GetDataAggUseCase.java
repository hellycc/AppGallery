package com.castro.helena.app.appgallery.helena.domain.usecase;

import io.reactivex.Single;

public interface GetDataAggUseCase<T> {
    Single<T> buildGetDataAggUseCase(String query);
}
