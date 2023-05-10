package com.castro.helena.app.appgallery.helena.domain.usecase;

import com.castro.helena.app.appgallery.helena.common.MyCustomDisposable;
import com.castro.helena.app.appgallery.helena.common.Resource;
import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataAggRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class GetDataAggUseCaseImpl implements GetDataAggUseCase<Resource<DataAggDto>> {

    final GetDataAggRepository repository;
    MyCustomDisposable lastDisposable;
    CompositeDisposable compositeDisposable;

    @Inject
    public GetDataAggUseCaseImpl(GetDataAggRepository repository, MyCustomDisposable lastDisposable, CompositeDisposable compositeDisposable) {
        this.repository = repository;
        this.lastDisposable = lastDisposable;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public Single<Resource<DataAggDto>> buildGetDataAggUseCase(String query) {
        return repository.getGalleryImages(query);
    }

    public void execute(String query, Consumer<Resource<DataAggDto>> onSuccess, Consumer<Throwable> onError, Action onFinished) {
        lastDisposable.dispose();
        lastDisposable = (MyCustomDisposable) buildGetDataAggUseCase(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(onFinished)
                .subscribe(onSuccess, onError);

        if (lastDisposable == null) {
            compositeDisposable.add(lastDisposable);
        }
    }

}
