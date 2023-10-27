class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) return true; // An empty string is valid

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else if (ch == ')') {
                if (!open.isEmpty()) {
                    open.pop(); // Match ')' with '('
                } else if (!star.isEmpty()) {
                    star.pop(); // Use '*' to match ')'
                } else {
                    return false; // No matching open parenthesis
                }
            }
        }

        // Check for remaining open parentheses and stars
        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.pop() > star.pop()) {
                return false; // Unmatched open parenthesis
            }
        }

        return open.isEmpty();
    }
}