package com.barran.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序,限于正整数；o(n+k),需要消耗额外的内存，稳定排序
 */
public class CountSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {

        int max = array[0], min = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            } else if (i < min) {
                min = i;
            }
        }

        countSort(array, min, max);
    }

    public void countSort(int[] array, int min, int max) {

        System.out.println("array: " + Arrays.toString(array));

        //这里k的大小是要排序的数组中，元素大小的差值+1
        int k = max - min + 1;

        // 构造计数数组
        int[] counts = new int[k];
        Arrays.fill(counts, 0);
        // 计算对应数字的次数
        for (int i : array) {
            counts[i - min]++;
        }

        System.out.println("counts: " + Arrays.toString(counts));

        // 计算小于或者等于i的元素个数
        for (int i = 1; i < k; i++) {
            counts[i] += counts[i - 1];
        }

        System.out.println("counts: " + Arrays.toString(counts));

        int length = array.length;
        int[] result = new int[length];
        int temp;

        for (int i = length - 1; i >= 0; i--) {
            temp = array[i];
            // 将待排序数组元素放到排序后数组B中指定的位置
            result[counts[temp - min] - 1] = temp;
            // 对应元素计数-1，以便存放下一个同样大小的元素（支持重复元素，且相对位置稳定）
            counts[temp - min]--;
        }
        System.out.println("sort: " + Arrays.toString(result));
    }
}
