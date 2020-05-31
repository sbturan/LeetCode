import java.util.LinkedList;
import java.util.Queue;

public class MagicalString {
	public static void main(String[] args) {
		System.out.println(new MagicalString().magicalString(14));
	}
    public int magicalString(int n) {
    	if(n==0) return 0;
    	int lenght=1,result=1;
    	Queue<Integer> q=new LinkedList<>();
    	q.add(22);
    	boolean lastCharOne=false;
        while(lenght<n) {
            int val=q.poll();
            System.out.print(val +"  ");
			lenght += val > 10 ? 2 : 1;
			if(val==11 && lenght<=n) {
				result+=2;
			}else if(val==1 || (val==11 && lenght>n)) {
				result+=1;
			}
			if (val == 1) {
				if (lastCharOne) {
					q.add(2);

				} else {
					q.add(1);
				}
				lastCharOne = !lastCharOne;
			}else if(val==2) {
				if(lastCharOne) {
					q.add(22);
				}else {
					q.add(11);
				}
				lastCharOne = !lastCharOne;
			}else if(val==11) {
				if(lastCharOne) {
					q.add(2);
					q.add(1);
				}else {
					q.add(1);
					q.add(2);
				}
			}else {
				if(lastCharOne) {
					q.add(22);
				}else {
					q.add(11);
				}
				lastCharOne = !lastCharOne;
			}
        }
        return result;
    }
}
