class Solution {
    public int calculate(String s) {
        
        Stack<Integer> operands = new Stack<>();
        Stack<Integer> operators = new Stack<>();
        int num = 0;
        int result = 0;
        int sign = 1; // 1 for positive, -1 for negative

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                operands.push(result);
                operators.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= operators.pop();
                result += operands.pop();
            }
        }

        if (num != 0) {
            result += sign * num;
        }

        return result;
        
    }
}