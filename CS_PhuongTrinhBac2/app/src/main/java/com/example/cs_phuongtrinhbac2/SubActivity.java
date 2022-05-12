package com.example.cs_phuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        EditText et_HeSoA= findViewById(R.id.editText_a);
        EditText et_HeSoB = findViewById(R.id.editText_b);
        EditText et_HeSoC= findViewById(R.id.editText_c);
        Button bt_submit= findViewById(R.id.button_submit);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.putExtra("a",et_HeSoA.getText().toString());
                intent.putExtra("b",et_HeSoB.getText().toString());
                intent.putExtra("c",et_HeSoC.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}