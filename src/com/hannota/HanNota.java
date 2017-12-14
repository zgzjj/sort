package com.hannota;

//汉诺塔递归
public class HanNota {
    private int i = 1;

    public void hanNota(int n, char from, char dependOn, char to) {
        if (n == 1) {
            move(1, from, to);
        } else {
            hanNota(n - 1, from, to, dependOn);
            move(n, from, to);
            hanNota(n - 1, dependOn, from, to);
        }
    }

    private void move(int n, char from, char to) {
        System.out.println("第" + i++ + "步从" + from + "------->" + to);
    }

    public static void main(String[] args) {
        HanNota hanNota = new HanNota();
        hanNota.hanNota(70, 'A', 'B', 'C');
    }
}

