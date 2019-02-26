package com.barran.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * <p>
 * 1.找到数组中最小的那个元素<br/>
 * 2.将最小的这个元素和数组中第一个元素交换位置<br/>
 * 3.在剩下的元素中找到最小的的元素，与数组第二个元素交换位置<br/>
 * 重复以上步骤至排序完成<br/>
 * </p>
 */
public class SelectSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        int minIndex = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            System.out.println((i + 1) + ","+ Arrays.toString(array));
        }
    }
}
