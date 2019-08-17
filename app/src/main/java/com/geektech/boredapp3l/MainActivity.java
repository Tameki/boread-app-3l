package com.geektech.boredapp3l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.geektech.boredapp3l.data.BoredApiClient;
import com.geektech.boredapp3l.data.IBoredApiClient;
import com.geektech.boredapp3l.model.BoredAction;
import com.geektech.boredapp3l.model.EActionType;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private BoredApiClient client;

    @BindView(R.id.spinner)
    Spinner spinner;

    @BindView(R.id.accessibility_progress)
    ProgressBar accessibilityProgress;

    @OnClick(R.id.refresh)
    void onClick(View view) {
        refreshAction();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        client = new BoredApiClient();

        refreshAction();
    }

    private void refreshAction() {
        int selected = spinner.getSelectedItemPosition();

        String type = null;

        if (selected != 0) {
            type = EActionType.values()[selected - 1]
                    .toString()
                    .toLowerCase();
        }

        client.getAction(0f, type, new IBoredApiClient.ActionCallback() {
            @Override
            public void onSuccess(BoredAction action) {
                int accessibility = (int) (action.getAccessibility() * 100);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    accessibilityProgress.setProgress(accessibility, true);
                } else {
                    accessibilityProgress.setProgress(accessibility);
                }

                Log.d("ololo", "Receive action - " + action.getTitle() + " " + action.getType());
            }

            @Override
            public void onFailure(Throwable exception) {
                Log.d("ololo", "Receive action failure " + exception.getMessage());
            }
        });

    }
}
