package com.peterdang.mvvm.domain.usecases;

import com.peterdang.mvvm.domain.repositories.LoginRepository;
import com.peterdang.mvvm.models.LoginModel;
import com.peterdang.mvvm.models.Response;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by phuoc on 2017-12-01.
 */

public class LoginUseCase extends BaseUseCase<Response<LoginModel>>{
    private final LoginRepository loginRepository;

    @Inject
    public LoginUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Single<Response<LoginModel>> execute(String username, String password){
        return loginRepository.login(username, password);
    }
}
