// Either both side -> <- | Either -> -> | Either <- <-
// Cases for opposite side moving 
// case 1 - if a>b a remains and b destroyed 
// case 2 - if a<b b reamins and a destroyed
// case 3 - if a==b both destroyed 
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int ast : asteroids) {
            boolean flag = true;

            while (!st.isEmpty() && ast < 0 && st.peek() > 0) {
                if (-ast > st.peek()) {
                    st.pop();
                } else if (-ast < st.peek()) {
                    flag = false;
                    break;
                } else {
                    flag = false;
                    st.pop();
                    break;
                }
            }
            // checking flag true or not if true then push
            if (flag) {
                st.push(ast);
            }
        }

        // Stack is last in, first out, that's why the for loop is from back to front
        int result[] = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}
