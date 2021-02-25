import java.util.PriorityQueue;

public class MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {
    public static void main(String[] args) {
        System.out.println(new MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves()
        .minDifference(new int[]{82,81,95,75,20}));
    }
    public int minDifference(int[] nums) {
        if (nums.length < 5)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> mins=new PriorityQueue<Integer>((i1,i2)->i2-i1);
        PriorityQueue<Integer> maxes=new PriorityQueue<Integer>();
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
           if(mins.size()<4){
               mins.add(i);
           }else if(mins.peek()>i){
               mins.poll();
               mins.add(i);
           }
           if(maxes.size()<4){
               maxes.add(i);
           }else if(maxes.peek()<i){
               maxes.poll();
               maxes.add(i);
           }
        }
        int[] maxReverse=new int[4];
        int result=Integer.MAX_VALUE;
        int index=3;
        while (!maxes.isEmpty()){
            maxReverse[index--]=maxes.poll();
        }
        for(int i=0;i<maxReverse.length;i++){
            result=Math.min(result,maxReverse[i]-mins.poll());
        }
        return result;
    }
}
