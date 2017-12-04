package com.peterdang.mvvm.ui.login;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.peterdang.mvvm.domain.usecases.LoginUseCase;

/**
 * Created by phuoc on 2017-12-02.
 */

public class LoginViewModelFactory implements ViewModelProvider.Factory {

    private final LoginUseCase loginUseCase;
    private final Application application;

    public LoginViewModelFactory(Application application, LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
        this.application = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(application, loginUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}