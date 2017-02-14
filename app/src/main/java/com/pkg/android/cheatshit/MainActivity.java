package com.pkg.android.cheatshit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

/**
 * Created by GAURAV on 13-02-2017.
 */

public class MainActivity extends AppCompatActivity {
    private AppCompatButton hollywood;
    private AppCompatButton bollywood;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hollywood = (AppCompatButton) findViewById(R.id.hollywood);
        bollywood = (AppCompatButton) findViewById(R.id.bollywood);

        hollywood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = CheatActivity.newIntent(MainActivity.this, 1);
                startActivity(i);
            }
        });

        bollywood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = CheatActivity.newIntent(MainActivity.this, 2);
                startActivity(i);
            }
        });
    }
}
