package com.alizhezi.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/main/HomeActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.main_btn_go_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

            }
        });
    }
}