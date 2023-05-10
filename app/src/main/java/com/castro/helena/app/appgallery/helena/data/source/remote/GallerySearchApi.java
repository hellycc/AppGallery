package com.castro.helena.app.appgallery.helena.data.source.remote;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GallerySearchApi {

    @GET("/gallery/search/")
    Single<Resource<DataAggDto>> getGallerySearch(@Query("q") String query);

}
