class MinStack {
    protected int[] data;
    private static int DEFAULT_SIZE=10;
    int ptr=-1;
    public MinStack() {
        this.data=new int[DEFAULT_SIZE];
    }
    public boolean isFull(){
        return ptr==data.length-1;
    }
    public boolean isEmpty(){
       return ptr==-1;
    }
    public void resize(){
        int[] newData=new int[data.length*2];
        for(int i=0;i<=ptr;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
    public void push(int val) {
        if(isFull()){
            resize();
        }
        data[++ptr]=val;
    }
    
    public void pop() {
        if(isEmpty()){
            return;
        }
        ptr--;
        
    }
    
    public int top() {
       if(isEmpty()){
        return -1;
       }
       return data[ptr];
    }
    
    public int getMin() {
         if(isEmpty()){
        return -1;
       }
        int min=data[0];
        for(int i=1;i<=ptr;i++){
            if(data[i]<min){
                min=data[i];
            }
        }
        return min;
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
