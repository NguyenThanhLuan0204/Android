package com.example.appone_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity2 extends AppCompatActivity {
    static  final String uri = "content://com.example.appone_provider";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product2);

        EditText et_id = findViewById(R.id.ID);
        EditText et_Name = findViewById(R.id.Name);
        EditText et_Unit = findViewById(R.id.unit);
        EditText et_Madein = findViewById(R.id.madein);
        GridView gv_display = findViewById(R.id.ProductList);

        Button  btn_Save = findViewById(R.id.Save);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("id",et_id.getText().toString());
                values.put("name",et_Name.getText().toString());
                values.put("unit",et_Unit.getText().toString());
                values.put("madein",et_Madein.getText().toString());
                Uri product = Uri.parse(uri);
                Uri insert_uri = getContentResolver().insert(product, values);
                Toast.makeText(getApplicationContext(), "Lưu thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        Button bt_select = findViewById(R.id.Select);
        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> string_list = new ArrayList<>();
                Uri product = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(product,null,null,null, "name");
                if(cursor != null){
                    cursor.moveToFirst();
                    do {
                        string_list.add(cursor.getInt(0),"");
                        string_list.add(cursor.getString(1));
                        string_list.add(cursor.getString(2));
                        string_list.add(cursor.getString(3));
                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductActivity2.this, android.R.layout.simple_list_item_1, string_list);
                    gv_display.setAdapter(adapter);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Không có kết quả!" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}