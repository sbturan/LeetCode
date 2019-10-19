public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int c5=0;
        int c10=0;
        for(int i=0;i<bills.length;i++) {
        	if(bills[i]==5) {
        		c5++;
        	}else if(bills[i]==10) {
        		if(c5==0) return false;
        		c5--;
        		c10++;
        	}else {
        		if(c5==0||(c10==0&&c5<3)) return false;
        		if(c10==0) c5-=3;
        		else {
        			c10--;
        			c5--;
        		}
        	}
        }
        return true;
    }
}
