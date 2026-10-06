class MinStack {

    List<Integer> valStack;
    List<Integer> minStack;
    int size;

    public MinStack() {
        this.valStack = new ArrayList<Integer>();
        this.minStack = new ArrayList<Integer>();
        size = 0;
    }
    
    public void push(int val) {
        valStack.add(val);
        int min = Integer.MAX_VALUE;
        if(!minStack.isEmpty()) {
            min = minStack.get(size - 1);
        }
        minStack.add(Math.min(min, val));
        size++;
    }
    
    public void pop() {
        valStack.removeLast();
        minStack.removeLast();
        size--;
    }
    
    public int top() {
        return valStack.get(size - 1);
    }
    
    public int getMin() {
        return minStack.get(size - 1);
    }
}
