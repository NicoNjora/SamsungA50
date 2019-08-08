package com.nicolletnjora.samsunga50;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hover.sdk.api.Hover;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hover.initialize(this);
    }
}
