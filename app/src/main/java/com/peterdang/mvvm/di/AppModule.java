package com.peterdang.mvvm.di;

import android.app.Application;
import android.content.Context;

import com.peterdang.mvvm.App;
import com.peterdang.mvvm.domain.repositories.LoginRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by phuoc on 2017-12-02.
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {
    @Provides
    Application provideContext(App application) {
        return application;
    }
}
