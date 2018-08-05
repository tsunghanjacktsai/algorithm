package pers.jack.sort;

/**
 * 選擇排序
 * @author jack870131
 */
public class SelectionSort {
	public static void selectionSort(int[] arr) {
		//如果数組為空或長度小於2不需要進行比較時直接返回
		if(arr == null || arr.length < 2) {
			return;
		}
 		//每一次循環到一個數都與其後面的所有數進行比較
		for(int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			//找到其後最小的數的下標
			for(int j = i + 1; j < arr.length; j++) {
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			//進行交換
			swap(arr, i, minIndex);
		}
	}

	public static void swap(int[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
	}
}
