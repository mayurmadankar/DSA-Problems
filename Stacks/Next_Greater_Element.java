//  time complexity - O(n)
// space complexity - O(n)

import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];

        for (int i =  n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            if (i < n) {
                if (!st.isEmpty()) {
                    result[i] = st.peek();
                } else {
                    result[i] = -1;
                }
            }
            st.push(arr[i]);
        }
        return result;
    }
}
