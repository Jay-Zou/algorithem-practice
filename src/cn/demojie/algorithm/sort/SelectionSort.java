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

        selectionSort.binarySelectionSort(array);
//        selectionSort.selectionSort(array);
        // [A, C, E, E, E, E, I, L, L, M, N, O, O, P, R, S, S, T, T, X]
        // [A, C, E, E, E, I, E, L, L, M, N, O, O, P, R, S, S, T, T, X]
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

    /**
     * 二元选择排序 O(n^2) 不稳定
     * <p>
     * 每次都找到最大值和最小值
     *
     * @param array
     */
    private void binarySelectionSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            int minIndex = i;
            int maxIndex = len - 1 - i;
            for (int j = i + 1; j <= len - 1 - i; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            Utils.swap(array, i, minIndex);
            Utils.swap(array, len - 1 - i, maxIndex);
        }
    }
    private void binarySelectionSort2(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            int minIndex = i;
            int maxIndex = len - 1 - i;
            for (int j = i + 1; j < len - 1 - i; j++) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                    continue;
                }
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Utils.swap(array, i, minIndex);
            }
            if (minIndex == len - 1 - i && maxIndex == i) {
                continue;
            }
            // 如果第一个位置为max，那么min交换后，把max给换掉了
            if (maxIndex == i) {
                maxIndex = minIndex;
            }
            if (maxIndex != len - 1 - i) {
                Utils.swap(array, len - 1 - i, maxIndex);
            }
            // TODO 算法还是有问题
        }
    }
}
