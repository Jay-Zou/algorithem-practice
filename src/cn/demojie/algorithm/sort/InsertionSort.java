package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        Utils.printArr(array);
        insertionSort.insertionSort(array);
        Utils.printArr(array);
    }

    /**
     * 直接插入排序
     *
     * 按顺序将当前的元素插入左侧已排好序的序列中
     * 插入的方法是： 将比当前元素大的元素往右移（交换）
     *
     * @param array
     */
    private void insertionSort(int[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        for (int i = 1; i < array.length; i++) {
            int index = i;
            while (index > 0 && array[index] < array[index - 1]) {
                Utils.swap(array, index, index - 1);
                index--;
            }
            Utils.printArr(array);
        }
    }

}
