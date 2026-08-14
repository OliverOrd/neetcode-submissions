class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        int top = -1;
        char[] stack = new char[s.length()];

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '[') {
                stack[++top] = ']';
            } else if (c == '{') {
                stack[++top] = '}';
            } else {
                if (top == -1 || stack[top--] != c) {
                    return false;
                }
            }
        }
        return top == -1;
    }
}
