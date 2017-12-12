package com.insertsort;

//希尔排序
public class HeerSort {
    public void sort(int[] a) {
        System.out.println("排序之前:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int d = a.length / 2;//默认增量
        int temp;
        while (true) {
            for (int i = 0; i < d; i++) {
                for (int j = i; j + d < a.length; j += d) {
                    if (a[j] > a[j + d]) {
                        temp = a[j];
                        a[j] = a[j + d];
                        a[j + d] = temp;
                    }
                }
            }
            if (d == 1) {
                break;
            }
            d--;
        }
        System.out.println("排序之后:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 14, 22, 34, 25, -9, 64, 72, 81, 1};
        HeerSort heerSort = new HeerSort();
        heerSort.sort(a);
    }
}
