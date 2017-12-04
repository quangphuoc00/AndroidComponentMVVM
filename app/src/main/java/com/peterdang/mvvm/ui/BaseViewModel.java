package com.peterdang.mvvm.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.Observable;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by phuoc on 2017-12-01.
 */

public class BaseViewModel extends AndroidViewModel implements Observable{
    protected final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<Boolean> loadingStatus = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getLoadingStatus() {
        return loadingStatus;
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {

    }
}
