package com.geektech.boredapp3l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.geektech.boredapp3l.data.BoredApiClient;
import com.geektech.boredapp3l.data.IBoredApiClient;
import com.geektech.boredapp3l.model.BoredAction;

public class MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BoredApiClient().getAction(new IBoredApiClient.ActionCallback() {
            @Override
            public void onSuccess(BoredAction action) {
                Log.d("ololo", "Receive action - " + action.getTitle());
            }

            @Override
            public void onFailure(Throwable exception) {
                Log.d("ololo", "Receive action failure " + exception.getMessage());
            }
        });
    }
}
