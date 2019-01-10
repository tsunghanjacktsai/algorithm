package pers.jack.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    public static class TwoQueuesStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            data.add(pushInt);
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1) {
                help.add(data.poll()); //如果隊列不為空，則將所有數放入另一個隊列
            }
            int res = data.poll();
            swap();
            return res;
        }

        /**
         * 改變引用(兩隊列引用交換)
         */
        public void swap() {
            Queue<Integer> temp = help;
            help = data;
            data = temp;
        }
    }
}
