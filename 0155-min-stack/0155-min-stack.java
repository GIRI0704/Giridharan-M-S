class MinStack {
private Stack<Integer> main;
    private Stack<Integer> aux;
    public MinStack() {
        main = new Stack<>();
        aux = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);
        if(aux.size() == 0 || val <= aux.peek())
        {
            aux.push(val);
        }
    }
    
    public void pop() {
        int num = main.pop();
        if(num == aux.peek())
        {
            aux.pop();
        }
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return aux.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */