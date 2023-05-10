package com.castro.helena.app.appgallery.helena.presentation.dataagg;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.castro.helena.app.appgallery.helena.domain.model.DataAgg;
import com.castro.helena.app.appgallery.helena.domain.usecase.GetDataAggUseCaseImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public final class DataAggViewModel extends ViewModel {

    private final MutableLiveData<DataAgg> _dataAgg = new MutableLiveData<>();
    final LiveData<DataAgg> dataAgg = _dataAgg;
    GetDataAggUseCaseImpl dataAggUseCaseImpl;

    @Inject
    public DataAggViewModel(GetDataAggUseCaseImpl dataAggUseCaseImpl) {
        this.dataAggUseCaseImpl = dataAggUseCaseImpl;
    }

    void fetchGallerySearch(String query) {
        dataAggUseCaseImpl.execute(
                query,
                dataAggDtoResource -> {
                    _dataAgg.getValue();
                },
                Throwable::printStackTrace,
                () -> {

                }
        );
    }

}
