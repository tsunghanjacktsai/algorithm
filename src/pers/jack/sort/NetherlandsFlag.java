package pers.jack.sort;

/**
 * 荷蘭國旗問題
 */
public class NetherlandsFlag {
    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1; //小於區域
        int more = r + 1; //大於區域
        int cur = l; //當前位置
        while(cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, l++);
            } else if (arr[cur] > num) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]=  tmp;
    }
}
