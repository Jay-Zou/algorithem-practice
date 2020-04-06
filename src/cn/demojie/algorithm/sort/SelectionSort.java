package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        // selection sort example
        Character[] array = {'S', 'E', 'L', 'E', 'C', 'T', 'I', 'O', 'N', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Utils.printArr(array);

        selectionSort.selectionSort(array);
        // [A, C, E, E, E, E, I, L, L, M, N, O, O, P, R, S, S, T, T, X]
        Utils.printArr(array);
    }


    /**
     * 选择排序 O(n^2) 不稳定
     * <p>
     * 遍历查找右侧数组中最小的元素的下标，然后与最左侧的元素交换，最左侧下标+1
     *
     * @param array
     */
    private void selectionSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int len = array.length;
        // 当遍历到倒数第二个元素时，只能和最后一个元素交换了，所以不需要遍历到最后一个元素
        for (int i = 0; i < len - 1; i++) {
            // 记录下右侧最小元素的下标
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Utils.swap(array, i, minIndex);
        }
    }
}
