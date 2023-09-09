import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>(); // Changed the stack type to Character

        for (int i = 0; i < num.length(); i++) { // Changed num.size() to num.length()
            char digit = num.charAt(i); // Extract the character at index i
            while (!st.isEmpty() && st.peek() > digit && k > 0) {
                st.pop();
                k--;
            }
            st.push(digit); // Push the character onto the stack
        }

        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder(); // Use StringBuilder to build the result
        while (!st.isEmpty()) {
            ans.insert(0, st.pop()); // Insert characters at the beginning of the StringBuilder
        }

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        // Returning a string from non-zeros
        return (i == ans.length()) ? "0" : ans.substring(i);
    }
}
