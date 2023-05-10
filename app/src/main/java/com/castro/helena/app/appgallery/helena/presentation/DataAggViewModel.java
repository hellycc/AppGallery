package com.castro.helena.app.appgallery.helena.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataDetailDto;
import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.usecase.dataagg.GetDataAggUseCase;
import com.castro.helena.app.appgallery.helena.domain.usecase.datadetail.GetDataDetailUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.scopes.ViewModelScoped;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public final class DataAggViewModel extends ViewModel {

    final SavedStateHandle handle;

    final GetDataAggUseCase dataAggUseCase;
    final GetDataDetailUseCase dataDetailUseCase;

    private final MutableLiveData<DataAgg> _dataAgg = new MutableLiveData<>();
    final LiveData<DataAgg> dataAgg = _dataAgg;

    private final MutableLiveData<DataDetail> _dataDetail = new MutableLiveData<>();
    final LiveData<DataDetail> dataDetail = _dataDetail;

    @Inject
    public DataAggViewModel(SavedStateHandle handle, final GetDataAggUseCase dataAggUseCase, GetDataDetailUseCase dataDetailUseCase) {
        this.handle = handle;
        this.dataAggUseCase = dataAggUseCase;
        this.dataDetailUseCase = dataDetailUseCase;
    }

    @ViewModelScoped
    public Observable<Resource<DataAggDto>> getDataAgg(String query) {
        Observable<Resource<DataAggDto>> response = dataAggUseCase.invoke(query);
        response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getDataAggObserver());
        return response;
    }

    @ViewModelScoped
    public Observable<DataDetailDto> getDataDetail() {
        Observable<DataDetailDto> response = dataDetailUseCase.invoke();
        response.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getDataDetailObserver());
        return response;
    }

    private Observer<Resource<DataAggDto>> getDataAggObserver() {
        return new Observer<Resource<DataAggDto>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                d.dispose();
                // show loading;
            }

            @Override
            public void onNext(@NonNull Resource<DataAggDto> dto) {
                _dataAgg.postValue((DataAgg) dto.getData().getDataAgg());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                _dataAgg.postValue(null);
            }

            @Override
            public void onComplete() {
                // hide loading;
            }
        };
    }

    private Observer<DataDetailDto> getDataDetailObserver() {
        return new Observer<DataDetailDto>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                d.dispose();
                // show loading;
            }

            @Override
            public void onNext(@NonNull DataDetailDto dto) {
                _dataDetail.postValue((DataDetail) dto.getImages());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                _dataDetail.postValue(null);
            }

            @Override
            public void onComplete() {
                // hide loading;
            }
        };
    }

}
