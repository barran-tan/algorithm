package com.barran.algorithm.sort;


import java.util.Stack;

/**
 * 快排的非递归实现
 * <br/>
 * 算法思想：{@link QuickSort}
 */
public class NonRecursiveQuickSort implements ISortAlgorithm {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    int partition(int array[], int low, int high) {
        int key = array[low];
        while (low < high) {
            while (low < high && array[high] >= key) high--;
            array[low] = array[high];
            while (low < high && array[low] <= key) low++;
            array[high] = array[low];
        }
        array[low] = key;
        return low;
    }

    //快速排序的非递归算法
    void quickSort(int array[], int low, int high) {
        Stack<Integer> st = new Stack<>();
        int key;
        do {
            while (low < high) {
                key = partition(array, low, high);
                //递归就是借助栈来实现
                if ((key - low) < (key - high)) {
                    st.push(key + 1);
                    st.push(high);
                    high = key - 1;
                } else {
                    st.push(low);
                    st.push(key - 1);
                    low = key + 1;
                }
            }
            if (st.empty())
                return;
            high = st.pop();
            low = st.pop();
        } while (true);
    }
}
