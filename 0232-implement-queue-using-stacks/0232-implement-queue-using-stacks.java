class MyQueue {
    private Stack<Integer> main;
    private Stack<Integer> aux;
    private int peek;
    public MyQueue() {
        main = new Stack<>();
        aux = new Stack<>();
    }
    
    public void push(int x) {
        if(main.size() == 0)
        {
            peek = x;
        }
        main.push(x);
    }
    
    public int pop() {
        while(main.size() > 0)
        {
            aux.push(main.pop());
        }
        int ans = aux.pop();
        if(aux.size() > 0)
        {
            peek = aux.peek();
        }
        while(aux.size() > 0)
        {
            main.push(aux.pop());
        }
        return ans;
    }
    
    public int peek() {
        return peek;
    }
    
    public boolean empty() {
        if(main.size() == 0) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */