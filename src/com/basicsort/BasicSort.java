package com.basicsort;

import java.util.ArrayList;
import java.util.List;

//基数排序
public class BasicSort {
    public void sort(int[] a) {
        int max = 0;//获取最大值
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        int times = 0;//获取最大值位数
        while (max > 0) {
            max = max / 10;
            times++;
        }
        List<ArrayList> queue = new ArrayList<ArrayList>();//多维数组
        for (int i = 0; i < 10; i++) {
            ArrayList q = new ArrayList();
            queue.add(q);
        }
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < a.length; j++) {
                //获取对应的位的值
                int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList q = queue.get(x);
                q.add(a[j]);
                queue.set(x, q);
            }
            //开始收集
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> q = queue.get(j);//拿到每一个数组
                    a[count] = q.get(0);
                    q.remove(0);
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {99, 234, 12, 33, 45, 67, 87, 9, 38, 765, 43, 22, 10, 578, 4};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("=================================");
        BasicSort basicSort = new BasicSort();
        basicSort.sort(a);
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
