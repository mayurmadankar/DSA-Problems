import java.util.ArrayDeque;

class Pair {
    int element;
    int Num;

    Pair(int ele, int no) {
        element = ele;
        Num = no;
    }
}

class Solution {
    public int m = (int) Math.pow(10, 9) + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        ArrayDeque<Pair> stack1 = new ArrayDeque<>();
        ArrayDeque<Pair> stack2 = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            int count = 1;
            while (!stack1.isEmpty() && stack1.peek().element > curr) {
                count += stack1.pop().Num;
            }
            stack1.push(new Pair(curr, count));
            left[i] = count;
        }

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            int count = 1;
            while (!stack2.isEmpty() && stack2.peek().element >= curr) {
                count += stack2.pop().Num;
            }
            stack2.push(new Pair(curr, count));
            right[i] = count;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (int) ((long) arr[i] * left[i] * right[i] % m)) % m;
        }
        return ans;
    }
}
