package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        Integer[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        Utils.printArr(array);

        insertionSort.insertionSort(array);
        // [13, 27, 38, 49, 49, 65, 76, 97]
        Utils.printArr(array);
    }

    /**
     * 直接插入排序
     * <p>
     * 按顺序将当前的元素插入左侧已排好序的序列中
     * 插入的方法是： 将比当前元素大的元素往右移（交换）
     * 时间复杂度：  1 + 2 + ... + n = (1 + n) * n / 2 = O(n^2)
     *
     * @param array
     */
    private void insertionSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        for (int i = 1; i < array.length; i++) {
            int index = i;
            // 依次将左侧比当前元素大的元素，往右移（交换）
            while (index > 0 && array[index].compareTo(array[index - 1]) < 0) {
                Utils.swap(array, index, index - 1);
                index--;
            }
        }
    }


    private void insertionSort2(int[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int index = i;
            // 注意，这里是和当前元素比较，而不是和上一个元素
            while (index > 0 && cur < array[index - 1]) {
                index--;
            }
            // 将左侧比当前元素小的元素，全部往右移动一格
            System.arraycopy(array, index, array, index + 1, i - index);
            // 将当前元素插入指定位置
            array[index] = cur;
            // Utils.printArr(array);
        }
    }

}
