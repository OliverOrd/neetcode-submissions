class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] firstCount = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            firstCount[c - 'a']++;
        }

        int[] secondCount = new int[26];
        int left = 0;
        for(int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            secondCount[c - 'a']++;
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(firstCount, secondCount)) {
                    return true;
                } else {
                    secondCount[s2.charAt(left) - 'a']--;
                    left++;
                }
            }
        }
        return false;
    }
}
