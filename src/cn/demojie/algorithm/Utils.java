package cn.demojie.algorithm;

public class Utils {
    /**
     * 打印整型数组
     *
     * @param arr
     */
    public static void printArr(Comparable[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(", " + arr[i]);
            }
        }
        System.out.println("]");
    }

    /**
     * 交换整型数组中两个元素
     *
     * @param array
     * @param i1
     * @param i2
     */
    public static void swap(Comparable[] array, int i1, int i2) {
        Comparable tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

}
