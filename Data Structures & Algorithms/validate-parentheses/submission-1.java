class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isClosed(c)) {
                stack.push(c);
            }
            else {
                if (stack.isEmpty() || stack.pop() != openEquiv(c)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isClosed(char c) {
        return c == ')' || c == '}' || c == ']';
    }
    private char openEquiv(char c) {
        if (c == ']') return '[';
        else if (c == '}') return '{';
        else return '(';
    }
}
