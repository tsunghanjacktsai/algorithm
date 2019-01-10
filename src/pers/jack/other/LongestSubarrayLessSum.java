package pers.jack.other;

import java.util.HashMap;

public class LongestSubarrayLessSum {
    public static int maxLengthAwesome(int[] arr, int aim) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] sums = new int[arr.length];
		HashMap<Integer, Integer> ends = new HashMap<Integer, Integer>();
		sums[arr.length - 1] = arr[arr.length - 1];
		ends.put(arr.length - 1, arr.length - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (sums[i + 1] < 0) {
				sums[i] = arr[i] + sums[i + 1];
				ends.put(i, ends.get(i + 1));
			} else {
				sums[i] = arr[i];
				ends.put(i, i);
			}
		}
		int R = 0;
		int sum = 0;
		int res = 0;
		for (int start = 0; start < arr.length; start++) {
			while (R < arr.length && sum + sums[R] <= aim) {
				sum += sums[R];
				R = ends.get(R) + 1;
			}
			sum -= R > start ? arr[start] : 0;
			res = Math.max(res, R - start);
			R = Math.max(R, start + 1);
		}
		return res;
	}

	public static int maxLength(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}

	public static int getLessIndex(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= num) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}
}
