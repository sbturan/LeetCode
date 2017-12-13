import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int total=0;
        List<Integer>  valids=new ArrayList<>();
        for(String s:ops) {
        	if(s.equals("+")) {
        		int cur=0;
        		if(valids.size()>0) {
        			cur+=valids.get(valids.size()-1);
        		}
        		if(valids.size()>1) {
        			cur+=valids.get(valids.size()-2);
        		}
        		total+=cur;
        		valids.add(cur);
        	}else if(s.equals("D")) {
        		int cur=0;
        		if(valids.size()>0) {
        			cur+=2*valids.get(valids.size()-1);
        			total+=cur;
        			valids.add(cur);        		}
        	}else if(s.equals("C")) {
        		if(valids.size()>0) {
        			total-=valids.get(valids.size()-1);
        			valids.remove(valids.size()-1);
        		}
        	}else {
        		valids.add(Integer.valueOf(s));
        		total+=Integer.valueOf(s);
        	}
        }
        
        return total;
    }
}
