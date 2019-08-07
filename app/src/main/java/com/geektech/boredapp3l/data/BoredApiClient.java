package com.geektech.boredapp3l.data;

import com.geektech.boredapp3l.model.BoredAction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BoredApiClient implements IBoredApiClient {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private BoredClient client = retrofit.create(BoredClient.class);

    @Override
    public void getAction(final ActionCallback callback) {
        Call<BoredAction> call = client.getAction();

        call.enqueue(new Callback<BoredAction>() {
            @Override
            public void onResponse(Call<BoredAction> call, Response<BoredAction> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onFailure(new Exception("Response body is empty" + response.message()));
                    }
                } else {
                    callback.onFailure(new Exception("Response code " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<BoredAction> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    interface BoredClient {

        @GET("api/activity/")
        Call<BoredAction> getAction(); //TODO: Add query parameters

    }

}
