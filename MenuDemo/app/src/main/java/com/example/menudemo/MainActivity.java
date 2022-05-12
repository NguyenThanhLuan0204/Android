package com.example.menudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnxemds:
                Toast.makeText(this, "Xem danh sách", Toast.LENGTH_LONG).show();
                return true;
            case R.id.mnxemdssv:
                Toast.makeText(this, "Xem danh sách sinh viên", Toast.LENGTH_LONG).show();
                return true;
            case R.id.mnsuads:
                // processing here
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}