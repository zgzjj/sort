package com.insertsort;

//直接插入排序
public class InsertSort {
    public void sort(int[] a) {
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        //开始直接插入排序
        int temp;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];//新遍历的值，等待插入到前面的有序数组
            int j;
            for (j = i - 1; j >= 0; j--) {
                //将大于temp的数往后移一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] a = {22, 18, 36, 47, 55, 88, 12, 8, 39, 66, 75, 0};
        insertSort.sort(a);
    }
}
