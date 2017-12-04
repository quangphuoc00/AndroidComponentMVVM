package com.peterdang.mvvm.di;

import com.peterdang.mvvm.ui.login.LoginActivity;
import com.peterdang.mvvm.ui.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity bindLobbyActivity();

    // Add bindings for other sub-components here
}