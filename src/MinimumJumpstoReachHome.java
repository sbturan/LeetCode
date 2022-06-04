import java.util.HashSet;

public class MinimumJumpstoReachHome {
    public static void main(String[] args) {
        System.out.println(new MinimumJumpstoReachHome().minimumJumps(new int[]{1,6,2,14,5,17,4},16,9,7));
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> visited=new HashSet<>();
        for(int i:forbidden)
            visited.add(i);
        helper(a,b,x,0,visited,0,false);
        return min==Integer.MAX_VALUE?-1:min;
    }
    int min=Integer.MAX_VALUE;
    private void helper( int a, int b, int x,int cur,HashSet<Integer> visited,int curStep,boolean prevBack){
        if(cur==x){
            min=Math.min(min,curStep);
            return;
        }
        if(cur<0||visited.contains(cur))
            return;
        visited.add(cur);
        if(cur<x)
            helper(a,b,x,cur+a,visited,curStep+1,false);
        if(!prevBack){
            helper(a,b,x,cur-b,visited,curStep+1,true);
        }
    }
}
