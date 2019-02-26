package com.barran.algorithm.sort;

/**
 * 冒泡排序
 *
 * <p>每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换</p>
 */
public class BubbleSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        int size = array.length;
        int i = 0, j = 0;
        int temp = 0;
        boolean flag;
        for (i = 0; i != size - 1; ++i) {
            flag = false;
            System.out.println(i + "  sort");
            for (j = 0; j != size - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                System.out.println("break");
                break;
            }
        }
    }
}
