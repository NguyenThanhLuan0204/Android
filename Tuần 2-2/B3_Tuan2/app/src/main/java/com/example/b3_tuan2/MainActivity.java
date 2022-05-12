package com.example.b3_tuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btnNhap;
    private TextView tvNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNhap = (TextView)findViewById(R.id.et_ten);
        myList = new ArrayList<String>();
        list = (ListView)findViewById(R.id.ListView_ds);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                myList);
        list.setAdapter(adapter);

        btnNhap=findViewById(R.id.bt_Nhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(tvNhap.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });
        TextView tvketQua = (TextView) findViewById(R.id.tv_ketqua);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                String msg = "position : " + arg2;
                msg += "; value : " + arg0.getItemAtPosition(arg2).toString();
                tvketQua.setText(msg);
            }
        });
    }
}