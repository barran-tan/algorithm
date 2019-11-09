package com.barran.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * <p>
 * 插入排序总共需要排序N-1趟，从index为1开始，将该位置上的元素与之前的元素比较，放入合适的位置
 * </p>
 */
public class InsertSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            //只能从当前索引往前循环，因为索引前的数组皆为有序的，索引只要确定当前索引的数据的位置即可
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }

            System.out.println(i + "" + Arrays.toString(array));
        }
        System.out.println("result " + Arrays.toString(array));
    }
}
