package com.peterdang.mvvm.domain.repositories;

import com.peterdang.mvvm.models.LoginModel;
import com.peterdang.mvvm.models.Response;

import io.reactivex.Single;

/**
 * Created by phuoc on 2017-12-01.
 */

public class LoginRepository {
    public Single<Response<LoginModel>> login(String username, String password){
        return Single.just(new Response<>(new LoginModel("token", "peter")));
    }
}
