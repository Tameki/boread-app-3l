package com.geektech.boredapp3l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.geektech.boredapp3l.data.BoredApiClient;
import com.geektech.boredapp3l.data.IBoredApiClient;
import com.geektech.boredapp3l.model.BoredAction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_title) TextView title;

    @OnClick(R.id.main_title)
    public void onClick(View view) {
        Toast.makeText(this, "Title click", Toast.LENGTH_SHORT).show();
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

        new BoredApiClient().getAction(null, "education", new IBoredApiClient.ActionCallback() {
            @Override
            public void onSuccess(BoredAction action) {
                title.setText(action.getTitle());
                Log.d("ololo", "Receive action - " + action.getTitle() + " " + action.getType());
            }

            @Override
            public void onFailure(Throwable exception) {
                Log.d("ololo", "Receive action failure " + exception.getMessage());
            }
        });
    }
}
