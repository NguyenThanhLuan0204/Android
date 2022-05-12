package com.example.cs02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button bt_Quaylai=findViewById(R.id.Button_QuayLai);

        String hoten=getIntent().getExtras().getString("ht");
        String namsinh=getIntent().getExtras().getString("ns");
        String st="";
        st="Họ Tên: "+hoten+"\n";
        st+="Sinh năm: "+namsinh;

        TextView tv_KetQua=findViewById(R.id.TextView_KetQua);
        tv_KetQua.setText(st);

        bt_Quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}