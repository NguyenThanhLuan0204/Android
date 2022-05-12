package com.example.test;
//Màn hình khởi động
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_Start= findViewById(R.id.button_Start);
        Button bt_Exit= findViewById(R.id.button_Exit);

        bt_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Run_App.class);
                startActivityForResult(intent,7777);
            }
        });
    }
}