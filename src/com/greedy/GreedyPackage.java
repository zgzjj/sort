package com.greedy;


import java.util.Arrays;

//贪心背包算法
public class GreedyPackage {
    private int MAX_WEIGHT = 150;
    private int[] weights = new int[]{35, 30, 60, 50, 40, 10, 25};
    private int[] values = new int[]{10, 40, 30, 50, 35, 40, 30};

    private void packageGreedy(int capacity, int weights[], int values[]) {
        int n = weights.length;
        double r[] = new double[n];//性价比数组
        int[] index = new int[n];//性价比排序物品的下标
        for (int i = 0; i < n; i++) {
            r[i] = (double) values[i] / (double) weights[i];
            index[i] = i;
        }
        double temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]) {
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }
        //排序好的质量和重量分别存到数组
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = weights[index[i]];
            v1[i] = values[index[i]];
        }
        int[] x = new int[n];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (w1[i] <= capacity) {
                //还可以装得下
                x[i] = 1;//表示该物品已经被装了
                maxValue += v1[i];
                System.out.println("物品" + w1[i] + "被放进背包");
                capacity = capacity - w1[i];
            }
        }
        System.out.println("总共放下的物品数量：" + Arrays.toString(x));
        System.out.println("获取的最大价值：" + maxValue);
    }

    public static void main(String[] args) {
        GreedyPackage greedyPackage = new GreedyPackage();
        greedyPackage.packageGreedy(greedyPackage.MAX_WEIGHT, greedyPackage.weights, greedyPackage.values);
    }
}

