package com.castro.helena.app.appgallery.helena.data.remote;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GallerySearchApi {

    @GET("/gallery/search/")
    Observable<Resource<DataAggDto>> getGallerySearch(@Query("q") String query);

}
