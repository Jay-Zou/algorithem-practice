package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

/**
 * 插入排序-希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        // shell sort example
        Character[] array = {'S', 'H', 'E', 'L', 'L', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        Utils.printArr(array);

        shellSort.shellSort(array);
        // [A, E, E, E, H, L, L, L, M, O, P, R, S, S, T, X]
        Utils.printArr(array);
    }

    /**
     * 希尔排序 O(n^1.3)
     * <p>
     * 使用步长h，每次都只将间隔h的元素使用插入排序
     * 然后逐渐缩短步长，直至h=1
     * 步长h的选择并不简单，这里我们使用《算法4》中的取值: h = 3 *h + 1 // 1, 4, 13, 40, 121, 364, 1093, ...
     *
     * @param array
     */
    private void shellSort(Comparable[] array) {
        if (null == array || array.length == 0) {
            throw new NullPointerException();
        }
        int len = array.length;
        int h = 1;
        // 1, 4, 13, 40, ...
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 注意： 这里是从h开始，先交换array[0]和array[h]、 array[1]和array[h+1]、 array[2]和array[h+2]、 ...
            for (int i = h; i < len; i++) {
                // 当 j = h时，上一个同步进的元素是array[0]，所以是循环的结束条件之一
                for (int j = i; j >= h && array[j].compareTo(array[j - h]) < 0; j -= h) {
                    Utils.swap(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
