package com.nicolletnjora.samsunga50;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hover.sdk.api.Hover;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hover.initialize(this);
    }
}
