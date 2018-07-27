package pers.sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i); //形成大根堆
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize); //最後一個位置的數和0位置交換
        while (heapSize > 0) {
            heapify(arr, 0, heapSize); //調出大根堆
            swap(arr, 0, --heapSize); //繼續跟0位置上的數交換
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) { //子節點比父位置大則交換
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) { //確保子節點不越界
            //判斷兩個子節點中哪個值較大
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            //左右節點中的最大值和指定數(被改變的數)比較哪個比較大
            largest = arr[largest] > arr[index] ? largest : index;
            //如果最大值是指定數則不用進行交換
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);//largest != index
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 9, 6, 10, 4, 7, 8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
