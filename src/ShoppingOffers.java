import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
      public static void main(String[] args) {
    	  ShoppingOffers  so=new ShoppingOffers();
    	  List<Integer> price= new ArrayList<>();
    	  List<List<Integer>> special=new ArrayList<>();
    	  List<Integer> needs=new ArrayList<>();
    	  price.add(2);price.add(3);price.add(4);
    	  List<Integer> s1=new ArrayList<>(); s1.add(1); s1.add(1);s1.add(4);
    	  List<Integer> s2=new ArrayList<>(); s2.add(1); s2.add(2);s2.add(10);
    	  special.add(s1);special.add(s2);
    	  needs.add(3);needs.add(2);
    	  System.out.println(so.shoppingOffers(price, special, needs));
	}
	   public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		   Map<List<Integer>,Integer> dp=new HashMap<>();
		   return helper(price,special,needs,dp);
	    }
	   
	   private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>,Integer> dp) {
		   if(needs.size()==0) {
			   return 0;
		   }
           if(dp.containsKey(needs)) {
        	   return dp.get(needs);
           }
		    
		   int allRegular=0;
		   for(int i=0;i<needs.size();i++) {
			   allRegular+=needs.get(i)*price.get(i);
		   }
		   
		   int min=Integer.MAX_VALUE;
		   for(int i=0;i<special.size();i++) {
			   int curTotal=0;
			   List<Integer> curSpecial=special.get(i);
			   List<Integer> newNeeds=new ArrayList<>(needs);
			   for(int j=0;j<newNeeds.size();j++) {
				   newNeeds.set(j,newNeeds.get(j)-curSpecial.get(j));
				   if(newNeeds.get(j)<0) {
					   curTotal=-1;
					   break;
				   }
			   }
			   if(curTotal>=0) {
				   curTotal+=curSpecial.get(curSpecial.size()-1);
				   min=Math.min(min,curTotal+helper(price, special, newNeeds,dp));
			   }
		   }
	        int result=Math.min(allRegular, min);
	        dp.put(needs, result);
		   return result;
	   
	   }
}
