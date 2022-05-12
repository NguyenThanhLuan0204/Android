package com.example.b2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_F= findViewById(R.id.editText_F);
        EditText et_C= findViewById(R.id.editText_C);
        Button bt_C= findViewById(R.id.button_C);
        Button bt_F= findViewById(R.id.button_F);
        Button bt_clear= findViewById(R.id.button_clear);

        bt_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int F=Integer.parseInt( et_F.getText().toString());
                et_C.setText(""+(F-32)*5/9);
            }
        });
        bt_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int C=Integer.parseInt( et_C.getText().toString());
                et_F.setText(""+(C*9/5+32));
            }
        });
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_C.setText("");
                et_F.setText("");
            }
        });

    }
}