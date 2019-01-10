package pers.jack.sort;

public class ArrayToStackQueue {
    public static class ArrayStack {
        private Integer[] arr;
        private Integer index;

        public ArrayStack(int initSize) {
            if (initSize > 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        /**
         * 返回棧頂
         *
         * @return
         */
        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index - 1];
        }

        /**
         * 壓入元素
         *
         * @param obj
         */
        public void push(int obj) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[index++] = obj;
        }

        /**
         * 取出元素
         *
         * @return
         */
        public Integer pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--index];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        /**
         * 返回堆棧的頭位置
         * @return
         */
        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        /**
         *  壓入元素
         * @param obj
         */
        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[end] = obj;
            /*
             * 如果 end 已經在最後一個位置則回到0
             * 如果沒有到最後一個位置則往下走1格
             */
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        /**
         * 取出元素
         * @return
         */
        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int temp = start;
            /*
             * start 來到最後一個位置則回到0
             * 否則 start 往下走1格
             */
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[temp];
        }
    }
}
