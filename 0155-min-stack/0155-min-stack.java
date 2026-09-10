class MinStack {
    Stack<Long> st;
    long mini;
    public MinStack() {
        st=new Stack<>();
    }
    public void push(int value) {
        long v=value;
        if(st.isEmpty()){
            mini=v;
            st.push(v);
            return;
            }
            if(v>mini){
                st.push(v);
            }
            else{
                 st.push(2 * v - mini);
                mini=v;
            }
        
    }
    
    public void pop() {
        if(st.isEmpty())return;
        long x=st.pop();
        if(x<mini){
            mini=2*mini-x;
        }
        return;
    }
    
    public int top() {
        if(st.isEmpty())return -1;
        long x=st.peek();
        if(mini<x)return (int)x;
        return (int)mini;
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */