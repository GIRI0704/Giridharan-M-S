class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            // While there are elements in the stack, the current digit is smaller than the top of the stack,
            // and we can still remove digits (k > 0), pop elements from the stack.
            while (!stack.isEmpty() && k > 0 && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            // Push the current digit onto the stack.
            stack.push(digit);
        }
        
        // If there are still remaining digits to be removed (k > 0), pop them from the stack.
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Build the result string from the stack.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Remove leading zeros.
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        if(result.length() == 0) return "0";
        return result.toString();
    }
}