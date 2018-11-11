
public class CircularArrayLoop {
	public static void main(String[] args) {
		CircularArrayLoop c=new CircularArrayLoop();
		System.out.println(c.circularArrayLoop(new int[] {3,1,2}));
	}
    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
		for(int i=0;i<length;i++) {
        	int startPointer=i,currentPointer=i;
        	int previousPointer=i;
        	boolean isNegative=nums[i]<0;
        	while(true) {
        		previousPointer=currentPointer;
        		currentPointer=(nums[currentPointer]+currentPointer)%length;
        		if(currentPointer<0)currentPointer+=length;
        		if(nums[currentPointer]<0^isNegative||currentPointer==previousPointer) {
        			break;
        		}
        		if(startPointer==currentPointer) {
        			return true;
        		}
        	}
        }
		return false;
    }
}
