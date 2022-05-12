package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Run_App extends AppCompatActivity {


    int manghinhbai[]={
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};
    int diemNguoi=0;
    int diemMay=0;
    int hoa=0;

    TextView edtTime;
    int nhay;
    Button btnStart,btnStop,btnTime;
    CountDownTimer Timer;
    CountDownTimer  Timer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_app);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edtTime =findViewById(R.id.edtTime);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnTime=findViewById(R.id.inputTime);
        ImageView iv1=findViewById(R.id.imageView1);
        ImageView iv2=findViewById(R.id.imageView2);
        ImageView iv3=findViewById(R.id.imageView3);
        ImageView iv4=findViewById(R.id.imageView4);
        ImageView iv5=findViewById(R.id.imageView5);
        ImageView iv6=findViewById(R.id.imageView6);
        TextView tv_KetQua1= findViewById(R.id.textView_KetQua1);
        TextView tv_KetQua2= findViewById(R.id.textView_KetQua2);
        TextView tv_diemMay2=findViewById(R.id.TextView_diemMay2);
        TextView tv_diemMay1=findViewById((R.id.TextView_diemMay1));
        TextView tv_hoa=findViewById((R.id.TextView_Hoa));

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(edtTime.getText().toString())==0){
                    Toast.makeText(Run_App.this,"Chưa cài đặt thời gian", Toast.LENGTH_SHORT).show();
                }
                else{
                    Timer = new CountDownTimer(Integer.parseInt(edtTime.getText().toString())*1000,nhay*1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int[]saulabai=lay6langaunhien(0,51);

                            int[]balabai1=new int[3];
                            //int[] balabai1={10,11,12};
                            //test 3 tây
                            System.arraycopy(saulabai,0,balabai1,0,3);
                            iv1.setImageResource(manghinhbai[balabai1[0]]);
                            iv2.setImageResource(manghinhbai[balabai1[1]]);
                            iv3.setImageResource(manghinhbai[balabai1[2]]);
                            tv_KetQua1.setText(tinhKetQua(balabai1));

                            int[]balabai2=new int[3];
                            System.arraycopy(saulabai,3,balabai2,0,3);
                            iv4.setImageResource(manghinhbai[balabai2[0]]);
                            iv5.setImageResource(manghinhbai[balabai2[1]]);
                            iv6.setImageResource(manghinhbai[balabai2[2]]);
                            tv_KetQua2.setText(tinhKetQua(balabai2));


                            if(tinhSoTay(balabai1)==3)
                            {
                                diemNguoi=diemNguoi+1;
                                tv_diemMay1.setText(""+diemNguoi);
                            }
                            else if(tinhSoTay(balabai2)==3)
                            {
                                diemMay=diemMay+1;
                                tv_diemMay2.setText(""+diemMay);
                            }
                            else
                            {
                                if(sosanhnut(balabai1,balabai2)==1)
                                {
                                    diemNguoi=diemNguoi+1;
                                    tv_diemMay1.setText(""+diemNguoi);
                                }
                                if(sosanhnut(balabai1,balabai2)==2)
                                {
                                    diemMay=diemMay+1;
                                    tv_diemMay2.setText(""+diemMay);
                                }
                                if(sosanhnut(balabai1,balabai2)==0){
                                    hoa=hoa+1;
                                    tv_hoa.setText(""+hoa);
                                }

                            }

                        }

                        @Override
                        public void onFinish() {
                            edtTime.setText("Hết giờ");
                        }
                    }.start();
                    Timer2 = new CountDownTimer(Integer.parseInt(edtTime.getText().toString())*1000,1000) {

                        @Override
                        public void onTick(long l) {
                            edtTime.setText(String.valueOf(l/1000));
                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();

                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer.cancel();
                Timer2.cancel();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Run_App.this,Input_Time.class);
                startActivityForResult(intent,8888);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==8888 && resultCode==RESULT_OK){
            String TimeNhap= data.getStringExtra("time").toString();
            String BuocNhayNhap= data.getStringExtra("buocnhay").toString();
            edtTime.setText(TimeNhap);
            nhay=Integer.parseInt(BuocNhayNhap);
        }
    }

    private int sosanhnut(int[]arr1,int[]arr2){
        int ss = 0;
        int tong1 = 0;
        int tong2 = 0;
        for (int i = 0; i < arr1.length; i++)
            if(arr1[i] % 13 < 10)
                tong1 += arr1[i] % 13 + 1;
        for (int i = 0; i < arr2.length; i++)
            if(arr2[i] % 13 < 10)
                tong2 += arr2[i] % 13 + 1;

        tong1=tong1%10;
        tong2=tong2%10;

        if(tong1>tong2)
            ss=1;
        else if(tong2>tong1)
            ss=2;
        else if(tong1==tong2)
            ss=0;

        return ss;
    }
    private String tinhKetQua(int[]arr){
        String ketqua = "";
        if(tinhSoTay(arr)==3)
            ketqua = "Kết quả 3 tây";
        else{
            int tong = 0;
            for (int i = 0; i < arr.length; i++)
                if(arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            if(tong % 10 ==0)
                ketqua = "Kết quả bù, số tây là " + tinhSoTay(arr);
            else
                ketqua = "Kết quả là " + (tong%10)+" nút, số tây là" + tinhSoTay (arr);
        }
        return ketqua;
    }
    private int tinhSoTay(int[]arr){
        int k = 0;
        for (int i = 0; i < arr.length; i++)
            if(arr[i] % 13 >= 10 && arr[i] < 13)
                k++;
        return k;
    }

    private int[] lay6langaunhien(int min, int max){
        int[]baso= new int[6];
        int i=0;
        baso[i++]=random(min,max);
        do {
            int k=random(min,max);
            if(!kiemtratrung(k,baso))
                baso[i++]=k;
        }while (i<6);
        return baso;
    }
    private boolean kiemtratrung(int k, int[]arr){
        for (int i=0;i<arr.length;i++)
            if (arr[i]==k)
                return true;
        return false;
    }
    private int random (int min, int max){
        return min+(int)(Math.random()*((max-min)+1));
    }
}