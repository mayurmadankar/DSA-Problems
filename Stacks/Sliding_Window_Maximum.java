class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n - k + 1];
    int resultIndex = 0;

    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++) {
        // Remove elements that are out of the current window from the front of the deque
        while (!deque.isEmpty() && deque.peek() < i - k + 1) {
            deque.poll();
        }

        // Remove elements from the back of the deque if they are smaller than the current element
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
            deque.pollLast();
        }

        // Add the current element's index to the back of the deque
        deque.offer(i);

        // If the current window is of size k or larger, store the maximum in the result array
        if (i >= k - 1) {
            result[resultIndex++] = nums[deque.peek()];
        }
    }

    return result;
}

}