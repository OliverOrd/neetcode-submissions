class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        //[1,2,4,6]
        //[1,1,2,8]
        //[48,24,12,8]
        int rightProduct = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return res;
    }
}  
