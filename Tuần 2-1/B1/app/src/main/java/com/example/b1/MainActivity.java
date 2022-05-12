package com.example.b1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_HeSoA= findViewById(R.id.editText_HeSoA);
        EditText et_HeSoB= findViewById(R.id.editText_HeSoB);
        Button bt_tong= findViewById(R.id.tong);
        Button bt_hieu= findViewById(R.id.hieu);
        Button bt_tich= findViewById(R.id.tich);
        Button bt_thuong= findViewById(R.id.thuong);
        Button bt_uoc= findViewById(R.id.uoc);
        Button bt_thoat= findViewById(R.id.thoat);
        TextView tv_KetQua= findViewById(R.id.textView_KetQua);

        bt_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt( et_HeSoA.getText().toString());
                int b=Integer.parseInt( et_HeSoB.getText().toString());
                int c= a+b;
                tv_KetQua.setText("Kết Quả: "+c);
            }
        });
        bt_hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt( et_HeSoA.getText().toString());
                int b=Integer.parseInt( et_HeSoB.getText().toString());
                int c= a-b;
                tv_KetQua.setText("Kết Quả: "+c);
            }
        });
        bt_tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt( et_HeSoA.getText().toString());
                int b=Integer.parseInt( et_HeSoB.getText().toString());
                int c= a*b;
                tv_KetQua.setText("Kết Quả: "+c);
            }
        });
        bt_thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float a= Float.parseFloat(et_HeSoA.getText().toString());
                Float b=Float.parseFloat( et_HeSoB.getText().toString());
                Float c= a/b;
                tv_KetQua.setText("Kết Quả: "+c);
            }
        });
        bt_uoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt( et_HeSoA.getText().toString());
                int b=Integer.parseInt( et_HeSoB.getText().toString());

                    if (a == 0 || b == 0){
                        tv_KetQua.setText("Kết Quả: "+(a+b));
                    }
                    while (a != b){
                        if (a > b){
                            a -= b; // a = a - b
                        }else{
                            b -= a;
                        }
                    }
                    tv_KetQua.setText("Kết Quả: "+a);
            }
        });
bt_thoat.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
    }
}