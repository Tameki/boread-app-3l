package com.geektech.boredapp3l.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geektech.boredapp3l.MainActivity;
import com.geektech.boredapp3l.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        MainActivity.start(this);
    }
}
