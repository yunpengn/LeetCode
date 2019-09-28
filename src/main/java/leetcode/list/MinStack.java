package leetcode.list;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> data;
    private final Stack<Integer> minimum;

    public MinStack() {
        data = new Stack<>();
        minimum = new Stack<>();
    }

    public void push(int x) {
        data.push(x);

        int newMinimum = minimum.empty() ? x : Math.min(minimum.peek(), x);
        minimum.push(newMinimum);
    }

    public void pop() {
        data.pop();
        minimum.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minimum.peek();
    }
}
