import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpentheLock {
    public static void main(String[] args) {
        System.out.println(new OpentheLock().openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
        System.out.println(new OpentheLock().openLock(new String[]{"8888"},"0009"));
        System.out.println(new OpentheLock().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));

    }
    public int openLock(String[] deadends, String target) {
        HashSet<Integer> blocks=new HashSet<>();
        for(String s:deadends){
            blocks.add(Integer.valueOf(s));
        }
        Integer tInt=Integer.valueOf(target);
        int step=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        blocks.add(0);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int val=q.poll();
                if(val==tInt)
                    return step;
                int cur=1000;
                while(cur>0){
                    int digit=(val/cur)%10;
                    int temp1=val-(digit*cur)+((digit+1)%10)*cur;
                    int temp2=val-(digit*cur)+((digit+9)%10)*cur;
                    if(!blocks.contains(temp1)){
                        q.add(temp1);
                        blocks.add(temp1);
                    }
                    if(!blocks.contains(temp2)){
                        q.add(temp2);
                        blocks.add(temp2);
                    }
                    cur/=10;
                }
            }
            step++;
        }
        return -1;
    }
}
