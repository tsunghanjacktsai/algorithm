package pers.jack.stackqueue;

public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tL = 0;
        int dR = matrix.length - 1;
        int dL = matrix[0].length - 1;
        while (tR <= dR && tL <= dL) {
            printEdge(matrix, tR++, tL++, dR--, dL--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tL, int dR, int dL) {
        if (tR == dR) {
            for (int i = tL; i <= dL; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if(tL == dL) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tL] + " ");
            }
        } else {
            int curL = tL;
            int curR = tR;
            while(curL != dL) {
                System.out.print(m[tR][curL] + " ");
                curL++;
            }
            while(curR != dR) {
                System.out.print(m[curR][dL] + " ");
                curR++;
            }
            while(curL != tL) {
                System.out.print(m[dR][curL] + " ");
                curL--;
            }
            while (curR != tR) {
                System.out.print(m[curL][dR] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }
}
