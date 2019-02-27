package com.barran.algorithm.sort;

/**
 * 堆排序，堆是完全二叉树，大顶堆是堆顶的值最大，小顶堆是堆顶的值最小<br/>
 * Ο(nlogn)
 *
 * <p>
 * 1.创建一个大顶堆
 * 2.堆首（最大值）和堆尾互换，堆的大小减1，然后调整堆（沉降法）
 * 3.重复步骤2直到堆大小为1
 * </p>
 */
public class HeapSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        final int length = array.length;
        buildHeap(array);

        for (int i = length - 1; i >= 1; i--) {
            swap(array, 0, i);
            maxHeap(array, 0, i);
        }
    }

    // 首次创建堆
    private static void buildHeap(int[] args) {
        int length = args.length;
        for (int i = length / 2; i >= 0; i--) {
            maxHeap(args, i, length);
        }
    }

    // 递归计算最大堆
    private static void maxHeap(int[] args, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int largest = index;

        if (left < size && args[left] > args[index]) {
            largest = left;
        }

        if (right < size && args[right] > args[largest]) {
            largest = right;
        }

        if (index != largest) {
            swap(args, index, largest);

            maxHeap(args, largest, size);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
