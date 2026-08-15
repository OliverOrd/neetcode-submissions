class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int res = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCount[c - 'A']++;
            int maxCount = maxCount(charCount);
            int windowLen = right - left + 1;

            if (windowLen > maxCount + k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
                windowLen--;
            }

            res = Math.max(res, windowLen);
        }
        return res;
    }

    private int maxCount(int[] counts) {
        int res = 0;
        for (int count : counts) {
            res = Math.max(res, count);
        }
        return res;
    }
}
