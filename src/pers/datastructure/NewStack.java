package pers.datastructure;

import java.util.Stack;

public class NewStack {
    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) { //棧為空
                this.stackMin.push(newNum);
            } else if(newNum < this.getmin()) { //新進元素比棧頂元素小
                this.stackMin.push(newNum); //壓入當前數
            } else { //新進元素重複壓入棧頂
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(newNum);
        }

        /**
         * 彈出最小元素
         * @return
         */
        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        /**
         * 返回棧頂得到最小元素
         * @return
         */
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}
