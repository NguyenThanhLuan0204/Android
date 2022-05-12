package com.example.cs_phuongtrinhbac2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView tv_KetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_PhuongTrinhBac2= findViewById(R.id.button_PhuongTrinhBac2);
        Button bt_PhuongTrinhBac1= findViewById(R.id.button_PhuongTrinhBac1);
        tv_KetQua= findViewById(R.id.textView_Ketqua);

        bt_PhuongTrinhBac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity_PhuongTrinhBac1.class);
                startActivityForResult(intent,7777);
            }
        });
        bt_PhuongTrinhBac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                startActivityForResult(intent,8888);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==8888 && resultCode==RESULT_OK){
            String HeSoA= data.getStringExtra("a").toString();
            String HeSoB= data.getStringExtra("b").toString();
            String HeSoC= data.getStringExtra("c").toString();

            int a= Integer.parseInt(HeSoA);
            int b= Integer.parseInt(HeSoB);
            int c= Integer.parseInt(HeSoC);
            GiaiPhuongTrinhBac2 giaiPhuongTrinhBac2= new GiaiPhuongTrinhBac2();
            tv_KetQua.setText(giaiPhuongTrinhBac2.giaiPhuongTrinhBac2(a,b,c));
        }
        if(requestCode==7777 && resultCode==RESULT_OK){
            String HeSoA= data.getStringExtra("a1").toString();
            String HeSoB= data.getStringExtra("b1").toString();
            int a= Integer.parseInt(HeSoA);
            int b= Integer.parseInt(HeSoB);
            GiaiPhuongTrinhBac1 giaiPhuongTrinhBac1= new GiaiPhuongTrinhBac1();
            tv_KetQua.setText(giaiPhuongTrinhBac1.Giai(a,b));
        }
        }

    }
