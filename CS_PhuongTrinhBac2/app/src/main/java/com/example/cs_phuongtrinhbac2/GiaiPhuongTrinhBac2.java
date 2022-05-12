package com.example.cs_phuongtrinhbac2;

public class GiaiPhuongTrinhBac2 {
    public static String giaiPhuongTrinhBac2(int a,int b, int c){
        String st;
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                st="Phương trình vô nghiệm!";
            } else {
                st="Phương trình có một nghiệm: "
                        + "x = " + (-c / b);
            }
            return st;
        }
        // tính delta
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            st="Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            st="Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1;
        } else {
            st="Phương trình vô nghiệm!";
        }
return st;
    }
}
