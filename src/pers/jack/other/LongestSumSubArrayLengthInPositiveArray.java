package pers.jack.other;

public class LongestSumSubArrayLengthInPositiveArray {
    public int getMaxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }

        int L = 0; // 左指針
        int R = 0; // 右指針
        int sum = arr[0];
        int len = 0;

        while (R < arr.length) {
            if (sum == aim) {
                len = Math.max(len, R - L + 1);
                sum -= arr[L++];
            } else if (sum < aim) {
                R++; //往右邊擴
                if (R == arr.length) {
                    break;
                }
                sum += arr[R];
            } else { // sum > aim
                sum -= arr[L++]; //往左邊擴
            }
        }
        return len;
    }
}
