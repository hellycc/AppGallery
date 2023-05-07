package com.castro.helena.app.appgallery.helena.data.remote;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GallerySearchApi {

    @GET("/gallery/search/")
    Observable<List<String>> getGallerySearch(@Query("q") String query);

}
