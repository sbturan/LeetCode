import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AvoidFloodinTheCity {

    public static void main(String[] args) {
        for(int i:new AvoidFloodinTheCity().avoidFlood(new int[]{1,2,0,0,2,1})){
            System.out.print(i+" ");
        }
    }
    public int[] avoidFlood(int[] rains) {
        int[] result=new int[rains.length];
        for(int i=0;i<result.length;i++){
            result[i]=-1;
        }
        Set<Integer> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<rains.length;i++){
            if(rains[i]>0){
                if(set.contains(rains[i])){
                    if(q.isEmpty())
                        return new int[0];
                    result[q.poll()]=rains[i];

                }else{
                    set.add(rains[i]);
                }
                result[i]=-1;
            }else{
                q.add(i);
            }
        }


        return result;
    }
}
