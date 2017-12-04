package com.peterdang.mvvm.domain.usecases;

import io.reactivex.Single;

/**
 * Created by phuoc on 2017-12-01.
 *  The use cases and their helpers could handle validation, reporting and other pre-processing tasks
 */

public abstract class BaseUseCase<T> {
    public abstract Single<T> execute(String username, String password);
}
