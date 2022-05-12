package com.example.cs03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
TextView tv_KetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_NhapThongTin= findViewById(R.id.button_NhapThongTin);
        tv_KetQua= findViewById(R.id.textView_KetQua);

        bt_NhapThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                startActivityForResult(intent,9999);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==9999 && resultCode==RESULT_OK){
            String ht= data.getStringExtra("ht").toString();
            String ns= data.getStringExtra("ns").toString();
            Calendar calendar= Calendar.getInstance();
            int namHienTai= calendar.get(Calendar.YEAR);
            int namSinh= Integer.parseInt(ns);
            String st ="";
            st+="Họ và tên: "+ht;
            st+="\nNăm Sinh: "+ns;
            st+="\nTuổi: "+(namHienTai-namSinh);
            tv_KetQua.setText(st);
        }
    }
}