import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinStack {

    /** initialize your data structure here. */

    List<Integer> list;
    PriorityQueue<Integer> queue;
    public MinStack() {
        list= new ArrayList<>();
        queue= new PriorityQueue<>();
    }

    public void push(int x) {
        list.add(x);
        queue.add(x);
    }

    public void pop() {
//        queue.poll();
        queue.remove(list.get(list.size()-1));
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return queue.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());//   --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top()); //     --> Returns 0.
        System.out.println(minStack.getMin());//  --> Returns -2.
    }
}
