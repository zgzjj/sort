package com.sort;

//二分法插入排序
public class BinaryInsertSort {
    public void sort(int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                //比left右边大的值往后移一位，等待temp插入
                a[j + 1] = a[j];
            }
            if (left != i) {
                a[left] = temp;
            }
        }
    }

    public static void main(String[] args) {
        BinaryInsertSort binaryInsertSort = new BinaryInsertSort();
        int[] a = {23, 66, 47, 70, 68, 90, 77, 88, 64, 53, 14, 3, 0, 99};
        System.out.println("排序之前:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        binaryInsertSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
