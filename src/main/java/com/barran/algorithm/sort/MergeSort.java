package com.barran.algorithm.sort;

/**
 * 归并排序
 *
 * <p>
 * 采用分治的思想，稳定排序，时间O(nlogn)，空间O(n)<br/>
 * 1, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素<br/>
 * 2, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作<br/>
 * 3, 合并: 合并两个排好序的子序列,生成排序结果 <br/>
 * </p>
 */
public class MergeSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    // [start,middle] [meddle+1,end]
    private void merge(int[] args, int start, int middle, int end) {

        int leftLengh = middle - start + 1;
        int rightLength = end - middle;

        int[] L = new int[leftLengh + 1];
        int[] R = new int[rightLength + 1];

        for (int i = 0; i < leftLengh; i++) {
            L[i] = args[start + i];
        }
        L[leftLengh] = Integer.MAX_VALUE;

        for (int j = 0; j < rightLength; j++) {
            R[j] = args[middle + j + 1];
        }
        R[rightLength] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (L[i] <= R[j]) {
                args[k] = L[i++];
            } else {
                args[k] = R[j++];
            }
        }
    }
}
