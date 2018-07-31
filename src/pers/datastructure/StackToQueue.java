package pers.datastructure;

import java.net.Inet4Address;
import java.util.Stack;

public class StackToQueue {
    public static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            this.stackPush = new Stack<Integer>();
            this.stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
            pour();
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pour(); //倒入元素
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pour();
            return stackPop.peek();
        }

        /**
         * 倒入元素
         */
        public void pour() {
            if (stackPop != null) {
                return;
            }

            while (stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
}
