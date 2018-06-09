import java.util.ArrayList;

class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.
		
	}

	    /** initialize your data structure here. */
		ArrayList<Integer> stack;
		ArrayList<Integer> mins;
		int pointer=-1;
	    public MinStack() {
	        stack=new ArrayList<>();
	        mins=new ArrayList<>();
	    }
	    
	    public void push(int x) {
	        stack.add(x);
	        if(pointer==-1){
	        	mins.add(x);
	        }else{
	        	mins.add(Integer.min(x, mins.get(pointer)));
	        
	        }
	        pointer++;
	    }
	    
	    public void pop() {
	    	if(pointer>-1){
	    		stack.remove(pointer);
		        mins.remove(pointer);
		        pointer--;	
	    	}
	        
	    }
	    
	    public int top() {
	    	if(pointer==-1) return -1;
	        return stack.get(pointer);
	    }
	    
	    public int getMin() {
	    	if(pointer==-1) return -1;
	        return mins.get(pointer);
	    }
	}