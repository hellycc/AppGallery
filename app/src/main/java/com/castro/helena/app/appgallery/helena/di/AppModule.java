package com.castro.helena.app.appgallery.helena.di;

import androidx.annotation.NonNull;

import com.castro.helena.app.appgallery.helena.BuildConfig;
import com.castro.helena.app.appgallery.helena.common.Constants;
import com.castro.helena.app.appgallery.helena.data.remote.GallerySearchApi;
import com.castro.helena.app.appgallery.helena.data.repository.GallerySearchRepositoryImpl;
import com.castro.helena.app.appgallery.helena.domain.repository.GallerySearchRepository;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    public GallerySearchApi provideGallerySearchApi() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GallerySearchApi.class);
    }


    @NonNull
    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Authorization", BuildConfig.API_KEY)
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        });
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor());
        }
        return builder.build();
    }

    private HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public GallerySearchRepository provideGallerySearchRepository(GallerySearchApi api) {
        return new GallerySearchRepositoryImpl(api);
    }

}
