package com.peterdang.mvvm.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.peterdang.mvvm.R;
import com.peterdang.mvvm.ui.login.LoginViewModel;
import com.peterdang.mvvm.ui.login.LoginViewModelFactory;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

public class MainActivity extends LifecycleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
