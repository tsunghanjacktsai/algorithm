package pers.jack.dynamicprogramming;

public class Hanoi {
    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }

    public static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }

    public static void moveLeftToRight(int n) {
        if(n == 1) {
            System.out.println("move 1 from left to right");
        }
        moveLeftToMid(n - 1);
        System.out.println("move " + n + "from left to right");
        moveMidToRight(n - 1);
    }

    public static void moveLeftToMid(int n) {
        if (n == 1) {
            System.out.println("move 1 from left to mid");
        }
        moveLeftToRight(n - 1);
        System.out.println("move " + n + "from left to mid");
        moveRightToMid(n - 1);
    }

    public static void moveRightToMid(int n) {

    }

    public static void moveMidToRight(int n) {
        if (n == 1) {
            System.out.println("move 1 from mid to right");
        }
        moveMidToRight(n - 1);
        System.out.println("move " + n + "from mid to right");
        moveLeftToRight(n - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }
}
