package com.barran.algorithm.sort;

import java.util.Random;

/**
 * 快速排序
 *
 * <p>
 * 1.选基准，一般选数列第一或者最后，优化思想是尽量取中位数，例如取第一个、最后一个及中间数的中位值<br/>
 * 2.分区，所有比基准小的放在左边分区，比基准大的数放在右边区<br/>
 * 3.将2个分区递归的使用上述步骤排列<br/>
 * 4.退出递归条件：分区只有1个或0个元素<br/>
 * </p>
 * <p>
 * 双向比较：最早由霍尔(Hoare)提出
 */
public class QuickSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
//            int p = partitionTwoWay(array, low, high);
            int p = partitionByThree(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    private int partitionFromLow(int array[], int low, int high) {

        int key = array[low];

        int i = low, j;

        for (j = low + 1; j <= high; j++) {
            if (array[j] < key) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i, low);

        return i;
    }

    private int partitionFromHigh(int array[], int low, int high) {
        int key = array[high];

        int i = low, j;

        for (j = low; j < high; j++) {
            if (array[j] < key) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i, high);

        return i;
    }

    private int partitionRandom(int array[], int low, int high) {

        // 随机[low,high]之间的数
        int random = new Random().nextInt(high - low + 1) + low;
        int temp = array[low];
        array[low] = array[random];
        array[random] = temp;
        int key = array[low];

        int i = low, j;

        for (j = low + 1; j <= high; j++) {
            if (array[j] < key) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i, low);

        return i;
    }

    //双向扫描
    private int partitionTwoWay(int array[], int low, int high) {
        int key = array[low];   //以第一个元素为主元
        int l = low;
        int h = high;
        while (l < h) {
            while (key <= array[h] && l < h)
                h--;
            array[l] = array[h];
            while (array[l] <= key && l < h)
                l++;
            array[h] = array[l];
        }
        array[l] = key;  //1.key只有出现要赋值的情况，才事先保存好第一个元素的值
        return l;     //这里是返回的是枢纽元素，即主元元素l
    }

    // 三数取中
    private int partitionByThree(int array[], int low, int high) {
        int m = (low + high) / 2;
        if (array[low] < array[m])
            swap(array, low, m);
        if (array[high] < array[m])
            swap(array, high, m);
        if (array[high] < array[low])
            swap(array, high, low);
        int key = array[low];
        int i = low;

        for (int j = low + 1; j <= high; j++) {
            if (array[j] < key) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i, low);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
