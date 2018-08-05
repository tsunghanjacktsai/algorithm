package pers.jack.stackqueue;

public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aL = 0;
        int bR = 0;
        int bL = 0;
        int endR = matrix.length - 1;
        int endL = matrix[0].length - 1;
        boolean fromUp = false;
        while (aR != endR + 1) {
            printLevel(matrix, aR, aL, bR, bL, fromUp);
            aR = aL == endL ? aR + 1 : aR; //a來到最後一列才往下一行
            aL = aL == endL ? aL : aL + 1; //a沒有到最後一列則繼續往右
            bL = bR == endR ? bL + 1 : bL; //b來到最後一行才往下一列
            bR = bR == endR ? bR : bR + 1; //b沒有到最後一行則繼續往下
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 打印邏輯
     * @param m
     * @param tR
     * @param tL
     * @param dR
     * @param dL
     * @param f
     */
    public static void printLevel(int[][] m, int tR, int tL, int dR, int dL, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tL--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dL++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}
