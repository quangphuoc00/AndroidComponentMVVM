package com.peterdang.mvvm.ui.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.peterdang.mvvm.R;
import com.peterdang.mvvm.databinding.ActivityLoginBinding;
import com.peterdang.mvvm.models.LoginModel;
import com.peterdang.mvvm.models.Response;
import com.peterdang.mvvm.ui.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class LoginActivity extends BaseActivity {
    private LoginViewModel loginViewModel;

    private ActivityLoginBinding mViewDataBinding;

    @Inject
    public LoginViewModelFactory loginViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        mViewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        ButterKnife.bind(this);

        loginViewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel.class);

        observeLoginResponse();

        observeLoadingStatus();

        mViewDataBinding.setViewmodel(loginViewModel);
    }

    private void observeLoadingStatus() {
        loginViewModel.getLoadingStatus().observe(this, isLoading -> {
            if (isLoading)
                showProgressDialog();
            else
                hideProgressDialog();
        });
    }

    private void observeLoginResponse() {
        loginViewModel.getLoginResponse().observe(this, new Observer<Response<LoginModel>>() {
            @Override
            public void onChanged(@Nullable Response<LoginModel> loginModelResponse) {
                showToast("login successfully");
//                Intent mI = new Intent(LoginActivity.this, MainActivity.class);
//                startActivity(mI);
//                LoginActivity.this.finish();
            }
        });
    }
}
