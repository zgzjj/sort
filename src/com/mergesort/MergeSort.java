package com.mergesort;

//归并排序
public class MergeSort {
    public void sort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(a, left, middle);
            sort(a, middle + 1, right);
            merge(a, left, middle, right);//合并
        }
    }

    private void merge(int[] a, int left, int middle, int right) {
        int[] tempArray = new int[a.length];
        int rightStart = middle + 1;
        int temp = left;
        int third = left;
        //比较两个小数组相应下标位置的数组大小，小的先放进数组
        while (left <= middle && rightStart <= right) {
            if (a[left] <= a[rightStart]) {
                tempArray[third++] = a[left++];
            } else {
                tempArray[third++] = a[rightStart++];
            }
        }
        //把左边数组剩余的元素放进数组
        while (left <= middle) {
            tempArray[third++] = a[left++];

        }
        //把右边数组剩余的元素放进数组
        while (rightStart <= right) {
            tempArray[third++] = a[rightStart++];

        }
        while (temp <= right) {
            a[temp] = tempArray[temp++];
        }
    }

    public static void main(String[] args) {
        int[] a = {34, 12, 15, 77, 64, 28, 98, 38, 10, 8, 49};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("=================================");
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a, 0, a.length - 1);
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
