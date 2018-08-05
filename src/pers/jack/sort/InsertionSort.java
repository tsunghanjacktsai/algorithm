package pers.jack.sort;

/**
 * 插入排序
 * @author jack870131
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        //如果数組為空或長度小於2則直接返回
        if (arr == null || arr.length < 2) {
            return;
        }
        //每次循環一個數
        for (int i = 1; i < arr.length; i++) {
            /*
             * 循環到的數的前一位數與其進行比較，如果大於則進行交換，
             * 不斷往前進行比較直到循環到的數之前的數都排序好才進行
             * 下一次循環
             */
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
