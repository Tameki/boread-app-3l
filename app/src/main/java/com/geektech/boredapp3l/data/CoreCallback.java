package com.geektech.boredapp3l.data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

abstract public class CoreCallback<T> implements Callback<T> {

    abstract void onSuccess(T result);
    abstract void onFailure(Exception exception);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            if (response.body() != null) {
                onSuccess(response.body());
            } else {
                onFailure(new Exception("Response body is empty" + response.message()));
            }
        } else {
            onFailure(new Exception("Response code " + response.code()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFailure(new Exception(t));
    }
}