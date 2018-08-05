package pers.jack.sort;

/**
 * 歸併排序
 * @author jack870131
 */
public class MergeSort {
	public static void mergeSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		sortProcess(arr, 0, arr.length - 1);
	}

	public static void sortProcess(int[] arr, int left, int right) {
		if(left == right) {
			return;
		}
		int mid = left + ((right - left) >> 1); //left 和 right 中點的位置 (left + right) / 2
		//左部分排序  T(N / 2)
		sortProcess(arr, left, mid);
		//右部分排序 T(N / 2)
		sortProcess(arr, mid + 1, right);
		//合併數組  O(N)
		merge(arr, left, mid, right);
		// T(N) = 2 T(N / 2) + O(N)
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		//輔助數組
		int[] help = new int[right - left + 1];
		int i = 0;
		int p1 = left;
		int p2 = mid + 1;
		while(p1 <= mid && p2 <= right) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		//兩個必有一個越界
		while(p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while(p2 <= right) {
			help[i++] = arr[p2++];
		}
		for(i = 0; i < help.length; i++) {
			arr[left + i] = help[i];
		}
	}
}
