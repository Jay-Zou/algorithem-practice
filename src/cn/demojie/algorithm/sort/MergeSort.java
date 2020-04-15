package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 递归实现的归排序
 * merge算法使用了辅助数组，然后拷贝回原数组
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Character[] array = {'M', 'E', 'G', 'E', 'R', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Utils.printArr(array);

        // [A, E, E, E, E, G, L, M, M, O, P, R, R, S, T, X]
        mergeSort.mergeSort(array);
        Utils.printArr(array);
    }

    /**
     * 归并排序 O(nlogn) 稳定
     * 自顶向下的递归实现
     *
     * @param array
     */
    private void mergeSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        sort(array, 0, array.length - 1);
    }

    // 递归算法
    private void sort(Comparable[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        // 拆成两个子数字，递归排序
        sort(array, start, mid);
        sort(array, mid + 1, end);
        // 归并两个数组
        merge(array, start, mid, end);
    }

    /**
     * 合并算法
     * 使用了辅助数组，然后拷贝回去
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private void merge(Comparable[] array, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        Comparable[] copy = new Comparable[array.length];

        for (int k = start; k <= end; k++) {
            if (i > mid) {
                copy[k] = array[j++];
            } else if (j > end) {
                copy[k] = array[i++];
            } else if (array[i].compareTo(array[j]) < 0) {
                copy[k] = array[i++];
            } else {
                copy[k] = array[j++];
            }
        }
        System.arraycopy(copy, start, array, start, end - start + 1);
    }

}
