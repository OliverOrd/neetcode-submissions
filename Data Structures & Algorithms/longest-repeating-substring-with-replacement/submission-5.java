class Solution {
    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int res = 0;
        int left = 0;
        int maxCount = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCount[c - 'A']++;
            maxCount = Math.max(maxCount, charCount[c - 'A']);

            while (right - left + 1 > maxCount + k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
