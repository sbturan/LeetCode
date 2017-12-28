
public class ConstructtheRectangle {
	   public int[] constructRectangle(int area) {
	     
		   int w=(int)Math.sqrt(area);
		   if(w*w!=area)w++;
		   while(area % w !=0) {
			   w++;
		   }
		   
		   return new int[] {w,area/w};
		   
	    }
}
