package pers.jack.sort;

/**
 * 小和問題
 * @author jack870131
 */
public class SmallSum {
	public static int smallSum(int[] arr) {
		if(arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSort(int[] arr, int l, int r) {
		if(l == r) {
			return 0;
		}
		int mid = l + ((r - l) >> 1); //mid = left + (right - left) / 2
		return mergeSort(arr, 1, mid)
				+ mergeSort(arr, mid + 1, r)
				+ merge(arr, 1, mid, r);
	}

	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - 1 + 1];
		int i = 0;
		int p1 = 1;
		int p2 = m + 1;
		int res = 0;
		while(p1 <= m && p2 <= r) {
			//p1 比 p2 小時，p2後面有多少個數乘當前p1自己 = p1 被榨出來的數量
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while(p1 <= m) {
			help[i++] = arr[p1++];
		}
		while(p2 <= r) {
			help[i++] = arr[p2++];
		}
		for(i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return res;
	}
}
