package com.example.b2_tuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cb_luu=findViewById(R.id.CheckBox_Luu);
        Button bt_DangNhap=findViewById(R.id.Button_DangNhap);
        Button bt_Thoat=findViewById(R.id.Button_Thoat);

        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb_luu.isChecked())
                    Toast.makeText(MainActivity.this,"Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu",Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu",Toast.LENGTH_SHORT).show();
            }
        });
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage(getResources ().getString(R.string.message_dialog_exist));
                builder.setTitle(getResources().getString(R.string.message_dialog_exist_title));
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton(getResources ().getString (R.string.message_dialog_ok),
                        new DialogInterface.OnClickListener () {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dialog.dismiss();
                                finish();}
                            });
                builder.setNegativeButton(getResources().getString(R.string.message_dialog_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });
    };
}