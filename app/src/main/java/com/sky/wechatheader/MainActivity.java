package com.sky.wechatheader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    /**
     *
     */
    private void setListener() {
        findViewById(R.id.tv_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FirstActivity.getIntent(MainActivity.this));
            }
        });
        findViewById(R.id.tv_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SecondActivity.getIntent(MainActivity.this));
            }
        });
        findViewById(R.id.tv_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ThirdActivity.getIntent(MainActivity.this));
            }
        });
    }
}
