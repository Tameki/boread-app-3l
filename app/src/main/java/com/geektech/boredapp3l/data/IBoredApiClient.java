package com.geektech.boredapp3l.data;

import com.geektech.boredapp3l.model.BoredAction;

public interface IBoredApiClient {

    void getAction(
            Float price,
            String type,
            ActionCallback callback
    );

    interface ActionCallback {
        void onSuccess(BoredAction action);

        void onFailure(Throwable exception);
    }
}
