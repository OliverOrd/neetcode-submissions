class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        int[] stack = new int[n];
        int top = -1;

        for(int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while(top > -1 && 
            temperatures[stack[top]] < temp) {
                int prevIndex = stack[top--];
                res[prevIndex] = i - prevIndex;
            }
            stack[++top] = i;
        }

        return res;
    }
}
