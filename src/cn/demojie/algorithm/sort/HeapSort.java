package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 堆排序：优先队列
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        // [null, 13, 27, 38, 49, 49, 65, 76, 97]
        Integer[] array = {null, 49, 38, 65, 97, 76, 13, 27, 49};
        Utils.printArr(array);

        heapSort.heapSort(array);
        Utils.printArr(array);

        // [13, 27, 38, 49, 49, 65, 76, 97]
        Integer[] array2 = {49, 38, 65, 97, 76, 13, 27, 49};
        Utils.printArr(array2);

        heapSort.heapSort2(array2);
        Utils.printArr(array2);
    }

    /**
     * 堆排序 O(nlogn) 不稳定
     *
     * @param array
     */
    private void heapSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        // 注意堆的长度比数组长度少1，因为 0 号位置不用
        int heapSize = array.length - 1;
        // 从最后一个结点的父节点开始，调用 sink。注意根节点也需要 sink
        for (int k = heapSize / 2; k >= 1; k--) {
            sink(array, k, heapSize);
        }
        // 当 heapSize = 2时，只需要交换剩下的两个元素，就有序了。所以不需要循环到1
        while (heapSize > 1) {
            Utils.swap(array, 1, heapSize--);
            sink(array, 1, heapSize);
        }
    }

    /**
     * 将当前结点下沉
     *
     * @param array
     * @param k
     * @param heapSize
     */
    private void sink(Comparable[] array, int k, int heapSize) {
        // 如果当前结点存在子结点
        while (2 * k <= heapSize) {
            int max = 2 * k;
            // 如果存在右子结点，并且比左子结点大，则 max 指向右子结点
            if (max < heapSize && array[max].compareTo(array[max + 1]) < 0) {
                max++;
            }
            // 如果当前结点大于子结点，说明已有序
            if (array[k].compareTo(array[max]) > 0) {
                break;
            }
            // 否则，交换
            Utils.swap(array, k, max);
            k = 2 * k;
        }
    }

    /**
     * 堆排序 O(nlogn) 不稳定
     *
     * @param array
     */
    private void heapSort2(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int end = array.length - 1;
        // 从最后一个结点的父节点开始，调用 sink。注意根节点也需要 sink
        for (int k = (end - 1) / 2; k >= 0; k--) {
            sink2(array, k, end);
        }
        while (end > 0) {
            Utils.swap(array, 0, end--);
            sink2(array, 0, end);
        }
    }

    /**
     * 将当前结点下沉
     *
     * @param array
     * @param k
     * @param end
     */
    private void sink2(Comparable[] array, int k, int end) {
        // 如果当前结点存在子结点
        while (2 * k + 1 <= end) {
            int max = 2 * k + 1;
            // 如果存在右子结点，并且比左子结点大，则 max 指向右子结点
            if (max < end && array[max].compareTo(array[max + 1]) < 0) {
                max++;
            }
            // 如果当前结点大于子结点，说明已有序
            if (array[k].compareTo(array[max]) > 0) {
                break;
            }
            // 否则，交换
            Utils.swap(array, k, max);
            k = 2 * k + 1;
        }
    }
}
