package com.peterdang.mvvm.ui.login;

import android.app.Application;

import com.peterdang.mvvm.domain.repositories.LoginRepository;
import com.peterdang.mvvm.domain.usecases.LoginUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by phuoc on 2017-12-03.
 */
@Module
public class LoginModule {
    @Provides
    public LoginRepository provideLoginRepository(){
        return new LoginRepository();
    }

    @Provides
    public LoginViewModelFactory provideLoginViewModelFactory(Application application, LoginUseCase loginUseCase){
        return new LoginViewModelFactory(application, loginUseCase);
    }
}
