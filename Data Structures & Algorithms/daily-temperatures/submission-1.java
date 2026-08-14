class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && 
            temperatures[stack.peekLast()] < temp) {
                int prevIndex = stack.pollLast();
                res[prevIndex] = i - prevIndex;
            }
            stack.addLast(i);
        }
        return res;
    }
}
