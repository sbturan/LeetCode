public class DailyTemperatures {
	public static void main(String[] args) {
		DailyTemperatures  d=new DailyTemperatures();
		int[] dailyTemperatures = d.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
		for(int i:dailyTemperatures) {
			System.out.print(i+ " ");
		}
		
	}
	public int[] dailyTemperatures(int[] temperatures) {
      int[] result=new int[temperatures.length];
      result[result.length-1]=0;
      for(int i=temperatures.length-2;i>-1;i--) {
    	  for(int j=i+1;j<result.length;j++) {
    		  if(temperatures[i]<temperatures[j]) {
    			  result[i]=j-i;
    			  break;
    		  }else if(temperatures[i]==temperatures[j]) {
    			  if(result[j]!=0) {
    				  result[i]=result[j]+j-i;
    			  }
    			  break;
    		  }else {
    			  if(result[j]==0) {
    				  break;
    			  }
    			  j=j+result[j]-1;
    		  }
    	  }
      }
      return result;
	}
}
