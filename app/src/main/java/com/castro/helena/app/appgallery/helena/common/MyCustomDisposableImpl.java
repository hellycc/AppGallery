package com.castro.helena.app.appgallery.helena.common;

import io.reactivex.disposables.Disposable;

public class MyCustomDisposableImpl implements MyCustomDisposable {

    public MyCustomDisposableImpl() {
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isDisposed() {
        return false;
    }

}
