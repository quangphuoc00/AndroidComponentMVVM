package com.peterdang.mvvm.models;

/**
 * Created by phuoc on 2017-12-02.
 */

public class Response<T>{
    private T data;

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
