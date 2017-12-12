package com.exchangesort;


//快速排序
public class QuickSort {
    public void quick(int[] a) {
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("==================================");
        if (a.length > 0) {
            quicksort(a, 0, a.length - 1);
            System.out.println("排序之后：");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }

    private void quicksort(int[] a, int low, int high) {
        if (low < high) {
            int middle = getMiddle(a, low, high);
            quicksort(a, 0, middle - 1);
            quicksort(a, middle + 1, high);
        }
    }

    //获取中间下标
    private int getMiddle(int[] a, int low, int high) {
        int temp = a[low];//基数
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;
    }

    public static void main(String[] agrs) {
        int[] a = {23, 45, 7, 11, 4, 57, 66, 25, 81, 65, 38, 21};
        QuickSort quickSort = new QuickSort();
        quickSort.quick(a);
    }
}
