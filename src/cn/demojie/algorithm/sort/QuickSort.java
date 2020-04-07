package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Integer[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        Utils.printArr(array);

        quickSort.quickSort(array);
        Utils.printArr(array);
    }

    /**
     * 快速排序 O（nlogn） 不稳定
     *
     * @param array
     */
    private void quickSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);
        Utils.printArr(array);
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    /**
     * 剑指 Offer 中用到的 Partition 算法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(Comparable[] array, int start, int end) {
        if (start == end) {
            return start;
        }
        int sentinel = end;
        int small = start;
        // 当只有两个元素的时候，第一个元素是需要比较的，所以要从 start 开始
        for (int i = start; i < end; i++) {
            if (array[i].compareTo(array[sentinel]) < 0) {
                Utils.swap(array, small, i);
                small++;
            }
        }
        Utils.swap(array, small, sentinel);
        return small;
    }

    /**
     * 《算法 4》 中的 Partition 算法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int algo4Partition(Comparable[] array, int start, int end) {
        int i = start;
        int j = end + 1;
        Comparable sentinel = array[start];
        while (true) {
            while (array[++i].compareTo(sentinel) < 0) {
                if (i == end) {
                    break;
                }
            }
            while (array[--j].compareTo(sentinel) > 0) {
                if (j == start) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            Utils.swap(array, i, j);
        }
        Utils.swap(array, start, j);
        return j;
    }
}
