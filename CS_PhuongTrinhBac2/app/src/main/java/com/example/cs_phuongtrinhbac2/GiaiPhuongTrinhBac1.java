package com.example.cs_phuongtrinhbac2;

public class GiaiPhuongTrinhBac1 {
    public static String Giai(int a,int b){
        String st;
        if(a==0){
            if(b==0) st="Phương trình vô số nghiệm";
            else st="Phương trình vô nghiệm";
        }
        else st="Phương trình có nghiệm"+(-b/a);
        return st;
    }
}
