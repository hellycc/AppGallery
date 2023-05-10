package com.castro.helena.app.appgallery.helena.presentation.datadetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.usecase.GetDataDetailUseCaseImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public final class DataDetailViewModel extends ViewModel {

    private final MutableLiveData<DataDetail> _dataDetail = new MutableLiveData<>();
    final LiveData<DataDetail> dataDetail = _dataDetail;

    GetDataDetailUseCaseImpl dataDetailUseCaseImpl;

    @Inject
    public DataDetailViewModel(GetDataDetailUseCaseImpl dataDetailUseCaseImpl) {
        this.dataDetailUseCaseImpl = dataDetailUseCaseImpl;
    }

    DataDetail fetchImageDetail() {
        return dataDetailUseCaseImpl.execute();
    }

}
