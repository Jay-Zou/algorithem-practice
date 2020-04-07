package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        Utils.printArr(array);

        bubbleSort.markEndBubbleSort(array);
        Utils.printArr(array);
    }


    /**
     * 冒泡排序 O(n^2) 稳定
     *
     * @param array
     */
    private void bubbleSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int len = array.length;
        // 循环的次数为： len - 1（0 ~ len-2），当剩下两个元素时，当一个排好序后，另一个就自然有序了
        for (int i = 0; i < len - 1; i++) {
            // j 不会循环到最后一个元素，因为 j 要和 j + 1 个元素比较
            // 当 i = 0 时，j 最大值为 len - 2，和 i 的最大值一样
            for (int j = 0; j < len - 1 - i; j++) {
                // 如果当前元素比下一个元素小，则交换
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Utils.swap(array, j, j + 1);
                }
            }
            Utils.printArr(array);
        }
    }

    /**
     * 判断是否交换的冒泡排序
     *
     * @param array
     */
    private void isExchangeBubbleSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            boolean isExchange = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Utils.swap(array, j, j + 1);
                    isExchange = true;
                }
            }
            if (!isExchange) {
                break;
            }
            Utils.printArr(array);
        }
    }

    /**
     * 记录最后交换的位置的冒泡排序
     *
     * @param array
     */
    private void markEndBubbleSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int len = array.length;
        int i = len - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    pos = j;
                    Utils.swap(array, j, j + 1);
                }
            }
            i = pos;
            System.out.println(i);
            Utils.printArr(array);
        }
    }


}
