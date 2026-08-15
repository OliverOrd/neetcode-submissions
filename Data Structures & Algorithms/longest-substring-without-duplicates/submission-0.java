class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        Map<Character,Integer> lastChar = new HashMap<>();

        for(int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            Integer prevIndex = lastChar.get(c);
            if (prevIndex != null) {
                left = Math.max(left, prevIndex + 1);
            }
            lastChar.put(c, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
