package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Input_Time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_time);
        EditText et_Time= findViewById(R.id.editText_time);
        EditText et_BuocNhay = findViewById(R.id.editText_buocnhay);
        Button bt_submit= findViewById(R.id.button_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(et_Time.length()==0){
                   Toast.makeText(Input_Time.this,"Thời gian không được rỗng", Toast.LENGTH_SHORT).show();
               }
               else  if(et_BuocNhay.length()==0){
                   Toast.makeText(Input_Time.this,"Bước nhảy không được rỗng", Toast.LENGTH_SHORT).show();
               }
               else if(Integer.parseInt(et_BuocNhay.getText().toString())>Integer.parseInt(et_Time.getText().toString()))
               {
                   Toast.makeText(Input_Time.this,"Bước nhảy không được lớn hơn thời gian", Toast.LENGTH_SHORT).show();
               }
               else{
                   Intent intent= new Intent();
                   intent.putExtra("time",et_Time.getText().toString());
                   intent.putExtra("buocnhay",et_BuocNhay.getText().toString());
                   setResult(RESULT_OK,intent);
                   finish();
               }
            }
        });
    }
    }