package com.selectsort;

//堆排序
public class HeapSort {
    public void sort(int[] a) {
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("===================================");
        if (a == null || a.length <= 1) {
            return;
        }
        //创建大堆
        buildMaxHeap(a);
        for (int i = a.length - 1; i >= 1; i--) {
            //最大元素排在了下标为0的地方
            exchangeElements(a, 0, i);//每交换一次，就沉淀一个大元素
            maxHeap(a, i, 0);
        }
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private void buildMaxHeap(int[] a) {
        int half = (a.length - 1) / 2;//只需遍历数组长度一半
        for (int i = half; i >= 0; i--) {
            maxHeap(a, a.length, i);
        }
    }

    //length表示用于构造大堆的数组长度
    private void maxHeap(int[] a, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < length && a[left] > a[i]) {
            largest = left;
        }
        if (right < length && a[right] > a[largest]) {
            largest = right;
        }
        if (i != largest) {
            //进行数据交换
            exchangeElements(a, i, largest);
            maxHeap(a, length, largest);
        }
    }

    private void exchangeElements(int[] a, int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }

    public static void main(String[] args) {
        int[] a = {44, 63, 56, 78, 20, 17, 33, 8, 72, 81, 108, 73};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a);
    }

}
