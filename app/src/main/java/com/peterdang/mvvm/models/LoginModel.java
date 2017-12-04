package com.peterdang.mvvm.models;

/**
 * Created by phuoc on 2017-12-01.
 */

public class LoginModel {
    private String token;
    private String username;

    public LoginModel(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
