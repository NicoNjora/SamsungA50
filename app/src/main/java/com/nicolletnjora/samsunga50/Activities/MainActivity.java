package com.nicolletnjora.samsunga50.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;
import com.nicolletnjora.samsunga50.R;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Hover.initialize(this);

        Button sampleButton;
        sampleButton = findViewById(R.id.sampleButton);
        sampleButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new HoverParameters.Builder(MainActivity.this)
                                .request("96e15773")
                                .buildIntent();
                        startActivityForResult(i, 0);
                    }
                }
        );
    }

    public void loginToHover(){

    }
}