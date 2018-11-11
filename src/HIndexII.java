
public class HIndexII {
	public static void main(String[] args) {
		System.out.println(new HIndexII().hIndex(new int[] {0,1}));
	}
    public int hIndex(int[] citations) {
         
    	int length = citations.length;
    	int start = 0, end = length - 1;
    	while (start <= end) {
    		int med = (end + start) / 2;
    		if (citations[med] == length - med) {
    			return length - med;
    		} else if (citations[med] < length - med) {
    			start = med + 1;
    		} else { 
    			end = med - 1;
    		}
    	}
    	return length - start;
    }
  
}
