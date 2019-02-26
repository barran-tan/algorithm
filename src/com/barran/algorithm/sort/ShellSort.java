package com.barran.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序，O(nlogn)
 *
 * <p>
 * 按步长 gap 分组，对每组记录采用直接插入排序方法进行排序。<br/>
 * 步长每次缩小一半，当步长的值减小到 1 时，整个数据合成为一组，构成一组有序记录，完成排序
 * </p>
 */
public class ShellSort implements ISortAlgorithm {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        int h = length / 2;
        int temp = 0;
        while (h >= 1) {

            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    temp = array[j];
                    array[j] = array[j - h];
                    array[j - h] = temp;
                }
                System.out.println(i + "(h=" + h + "):" + Arrays.toString(array));
            }

            System.out.println("h=" + h + ":" + Arrays.toString(array));

            h /= 2;
        }
    }
}
