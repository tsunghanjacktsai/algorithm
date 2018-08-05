package pers.jack.stackqueue;

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tL = 0;
        int dR = matrix.length - 1;
        int dL = matrix[0].length - 1;
        while(tR < dR) {
            rotateEdge(matrix, tR++, tL++, dR--, dL--);
        }
    }

    public static void rotateEdge(int[][] m, int tR, int tL, int dR, int dL) {
        int times = dL - tL;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tL + i];
            m[tR][tL + i] = m[dR - i][tL];
            m[dR - i][tL] = m[dR][dL - i];
            m[dR][dL - i] = m[tR + i][dL];
            m[tR + i][dL] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
