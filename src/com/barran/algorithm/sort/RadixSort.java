package com.barran.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序,排序范围为整数（包括负数）
 */
public class RadixSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        int count = countDigit(array);

        radixSort(array, 10, count);
    }

    //基于计数排序的基数排序算法
    public static void radixSort(int[] array, int radix, int digitCount) {
        //array为待排序数组
        // radix，代表基数，实际就是几个数字，那就是10喽
        // digit代表排序元素的位数，实际意义是排序趟数
        int length = array.length;
        int[] res;
        int[] c = new int[radix];//radix就是10，因为0到9共10个数字
        int divide = 1;//用于每次把数字缩小10倍
        for (int i = 0; i < digitCount; i++) {
            res = Arrays.copyOf(array, length);
            Arrays.fill(c, 0);
            for (int j = 0; j < length; j++) {
                int tempKey = (res[j] / divide) % radix;
                c[tempKey]++;
            }

            //C[A[i]]表示小于等于a[i]的元素个数
            for (int j = 1; j < radix; j++) {
                c[j] = c[j] + c[j - 1];
            }

            for (int j = length - 1; j >= 0; j--) {
                int tempKey = (res[j] / divide) % radix;
                array[c[tempKey] - 1] = res[j];
                c[tempKey]--;
            }
            divide = divide * radix;
        }
    }

    public static int countDigit(int[] array) {

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
        return time;
    }
}
