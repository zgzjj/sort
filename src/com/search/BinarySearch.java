package com.search;

import java.util.Arrays;

//二分查找
public class BinarySearch {
    //采用递归
    public int search(int elem, int[] a, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (a[middle] == elem) {
            System.out.println("使用递归二分查找找到元素" + a[middle] + "下标为" + middle);
            return middle;
        }
        if (a[middle] < elem) {
            return search(elem, a, middle + 1, high);
        }
        if (a[middle] > elem) {
            return search(elem, a, low, middle - 1);
        }
        return -1;
    }

    //不采用递归
    public int search2(int elem, int[] a) {
        int low = 0;
        int high = a.length;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (elem > a[middle]) {
                low = middle + 1;
            }
            if (elem < a[middle]) {
                high = middle - 1;
            }
            if (elem == a[middle]) {
                System.out.println(a[middle]);
                System.out.println("使用非递归二分查找找到元素" + a[middle] + "下标为" + middle);
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 2, 34, 24, 33, 19, 55, 64, 42};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.search(33, a, 0, a.length);
        binarySearch.search2(34, a);
    }
}

