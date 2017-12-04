package com.peterdang.mvvm.ui.login;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.peterdang.mvvm.domain.usecases.LoginUseCase;
import com.peterdang.mvvm.models.LoginModel;
import com.peterdang.mvvm.models.Response;
import com.peterdang.mvvm.ui.BaseViewModel;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by phuoc on 2017-12-01.
 */

public class LoginViewModel extends BaseViewModel {
    private final LoginUseCase loginUseCase;

    public final ObservableField<String> username = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();

    private final MutableLiveData<Response<LoginModel>> loginResponse = new MutableLiveData<>();

    public LoginViewModel(Application application, LoginUseCase loginUseCase) {
        super(application);
        this.loginUseCase = loginUseCase;
    }

    public MutableLiveData<Response<LoginModel>> getLoginResponse() {
        return loginResponse;
    }

    public void login(View view) {
        disposables.add(loginUseCase.execute(username.get(), password.get())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> getLoadingStatus().setValue(true))
                .doAfterTerminate(() -> getLoadingStatus().setValue(false))
                .subscribe(loginModelResponse -> {
                            Thread.sleep(1000);
                            this.loginResponse.setValue(loginModelResponse);
                        },
                        throwable -> {
                            Log.e("loginError", throwable.getMessage());
                        }));
    }
}

