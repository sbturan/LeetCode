
public class FindLuckyIntegerinanArray {
    public int findLucky(int[] arr) {
       
       int counts[]=new int[501];
       for(int i:arr) {
    	   counts[i]++;
       }
       for(int i=500;i>0;i--) {
    	   if(i==counts[i]) {
    		   return i;
    	   }
       }
       return -1;
    }
}
