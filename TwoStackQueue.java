import org.junit.Test;

import java.util.Stack;

public class TwoStackQueue {
    /**
     * 用两个栈来实现一个队列，
     * 完成队列的Push和Pop操作。
     * 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return value;
    }

    @Test
    public void test() {
        TwoStackQueue mTwoStackQueue = new TwoStackQueue();
        mTwoStackQueue.push(1);
        mTwoStackQueue.push(2);
        mTwoStackQueue.push(3);
        mTwoStackQueue.push(4);
        mTwoStackQueue.pop();
    }

}
