//tc-O(m-1) or O(n-1)
//sc-O(1)
class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2; // total steps to be taken
        int r = Math.min(m - 1, n - 1); // choose the smaller one for fewer iterations
        double res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) Math.round(res); // round the result to handle floating-point arithmetic
    }
}
