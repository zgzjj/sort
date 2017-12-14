package com.gcd;

//欧几里得求最大公约数
public class Gcd {
    public int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }

    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        int x = gcd.gcd(36, 24);
        System.out.println("最大公约数为：" + x);
    }
}
