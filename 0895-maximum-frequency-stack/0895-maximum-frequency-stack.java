class FreqStack {
     private HashMap<Integer, Integer> map;
	private HashMap<Integer, Stack<Integer>> stackMap;
	private int max;

    public FreqStack() {
        map = new HashMap<>();
		stackMap = new HashMap<>(); 
		max = 0;
    }
    
    public void push(int x) {
        if(map.containsKey(x))
		{
			map.put(x, map.get(x)+1);
		}
		else
		{
			map.put(x,1);
		}
		max = Math.max(max,map.get(x));
		int currentfreq = map.get(x);
		if(stackMap.containsKey(map.get(x)))
		{
			Stack<Integer> stack = stackMap.get(map.get(x));
			stack.push(x);
			stackMap.put(currentfreq, stack);
		}
		else
		{
			Stack<Integer> stack = new Stack<>();
			stack.push(x);
			stackMap.put(currentfreq, stack);
		}
    }
    
    public int pop() {
        int currentMax = max;
		int popped = 0;
		if(stackMap.containsKey(currentMax))
		{
			Stack<Integer> stack = stackMap.get(currentMax);
            popped = stack.pop();
			if(stack.size() == 0) max--;
			stackMap.put(currentMax, stack);
		}
        
       map.put(popped, map.get(popped)-1);
       
        
		return popped;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */