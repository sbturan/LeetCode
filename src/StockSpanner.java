import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
	List<Integer> list;
	public StockSpanner() {
     list=new ArrayList<Integer>();
	}

	public int next(int price) {
       int result=1;
       int i=list.size()-1;
       list.add(price);
       while(i>-1 && list.get(i)<=price) {
    	   i--;
    	   result++;
       }
    	return result;
	}
}
