package pers.jack.tree;

public class IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnDate {
        public boolean isB;
        public int h;

        public ReturnDate(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isB(Node head) {
        return process(head).isB;
    }

    public static ReturnDate process(Node head) {
        if (head == null) {
            return new ReturnDate(true, 0);
        }

        ReturnDate leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnDate(false, 0);
        }

        ReturnDate rightData = process(head.right);
        if (!rightData.isB) {
            return new ReturnDate(false, 0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnDate(false, 0);
        }
        return new ReturnDate(true, Math.max(leftData.h, rightData.h) + 1);
    }
}

