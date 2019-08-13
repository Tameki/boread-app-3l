package com.geektech.boredapp3l.data;

import com.geektech.boredapp3l.model.BoredAction;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class BoredApiClient implements IBoredApiClient {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private BoredClient client = retrofit.create(BoredClient.class);

    @Override
    public void getAction(
            Float price,
            String type,
            final ActionCallback callback
    ) {
        Call<BoredAction> call = client.getAction(price, type);

        call.enqueue(new CoreCallback<BoredAction>() {
            @Override
            void onSuccess(BoredAction result) {
                callback.onSuccess(result);
            }
            @Override
            void onFailure(Exception exception) {
                callback.onFailure(exception);
            }
        });
    }

    interface BoredClient {

        @GET("api/activity/")
        Call<BoredAction> getAction(
                @Query("price") Float price,
                @Query("type") String type
        ); //TODO: Add query parameters

    }

}
