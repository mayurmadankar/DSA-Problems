// time complexity - O(1) for push and pop and O(1) for amotised this is because when input stack have many element to transfer from input to output
// space complexity - O(2n) for two stack 

import java.util.Stack;

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    private void transfer() {
        while (!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    public int pop() {
        if (output.isEmpty()) {
            transfer();
        }
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            transfer();
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */