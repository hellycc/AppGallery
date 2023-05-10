package com.castro.helena.app.appgallery.helena.di;

import androidx.annotation.NonNull;

import com.castro.helena.app.appgallery.helena.BuildConfig;
import com.castro.helena.app.appgallery.helena.common.Constants;
import com.castro.helena.app.appgallery.helena.common.MyCustomDisposable;
import com.castro.helena.app.appgallery.helena.common.MyCustomDisposableImpl;
import com.castro.helena.app.appgallery.helena.data.source.remote.GallerySearchApi;
import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public GallerySearchApi provideGallerySearchApi() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL + Constants.API_VERSION)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GallerySearchApi.class);
    }

    @NonNull
    private OkHttpClient getOkHttpClient() {
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
            builder.addInterceptor(getLoggingInterceptor());
        }
        return builder.build();
    }

    private HttpLoggingInterceptor getLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @Singleton
    public MyCustomDisposable provideMyCustomDisposable() {
        return new MyCustomDisposableImpl();
    }

}
