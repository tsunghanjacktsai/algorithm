package pers.jack.dynamicprogramming;

public class CardsInLine {
    // 暴力遞歸
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(a(arr, 0, arr.length - 1), b(arr, 0, arr.length - 1));
    }

    private static int a(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + b(arr, i + 1, j), arr[j] + b(arr, i, j - 1));
    }

    private static int b(int[] arr, int i, int j) { //violation, the initial letter
                                                    // should match the pattern [a-z]
        if (i == j) {
            return 0;
        }
        return Math.min(a(arr, i + 1, j), a(arr, i, j - 1));
    }

    // 動態規劃
    public static int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] a = new int[arr.length][arr.length];
        int[][] b = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            a[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                a[i][j] = Math.max(arr[i] + b[i + 1][j], arr[j] + b[i][j - 1]);
                b[i][j] = Math.max(a[i + 1][j], a[i][j - 1]);
            }
        }
        return Math.max(a[0][arr.length - 1], b[0][arr.length - 1]);
    }
}
