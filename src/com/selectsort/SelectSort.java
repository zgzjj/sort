package com.selectsort;

//简单选择排序
public class SelectSort {
    public void sort(int[] a) {
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("==============================");
        int min;
        int temp;
        for (int i = 0; i < a.length; i++) {
            min = a[i];
            for (int j = i; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    temp = a[i];
                    a[i] = min;
                    a[j] = temp;
                }
            }
        }
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int a[] = {43, 21, 55, 37, 8, 0, 67, 99, 81, 32, 48};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(a);
    }
}
