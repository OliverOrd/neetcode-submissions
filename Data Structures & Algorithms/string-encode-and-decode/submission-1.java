class Solution {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) {
            stringBuilder.append(s.length());
            stringBuilder.append('#');
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length) {
            int j = i;
            while (chars[j] != '#') {
                j++;
            }
            int length = j - i;
            int n = Integer.parseInt(new String(chars, i, length));
            res.add(new String(chars, j+1, n));
            i += length + 1 + n;
        }
        return res;
    }
}
