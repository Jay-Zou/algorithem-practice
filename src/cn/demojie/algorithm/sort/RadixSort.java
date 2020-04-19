package cn.demojie.algorithm.sort;

import cn.demojie.algorithm.Utils;

public class RadixSort {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        Integer[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        Utils.printArr(array);

        radixSort.radixSort(array);
        Utils.printArr(array);
    }

    private void radixSort(Integer[] array) {

    }

}
