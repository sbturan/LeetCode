import java.util.Arrays;

public class SumofMutatedArrayClosesttoTarget {
    public static void main(String[] args) {
        System.out.println(new SumofMutatedArrayClosesttoTarget()
                .findBestValue(new int[]{1547,83230,57084,93444,70879},71237));
        System.out.println(new SumofMutatedArrayClosesttoTarget()
                .findBestValue(new int[]{1,2,23,24,34,36},110));
    }
    public int findBestValue(int[] arr, int target) {
       Arrays.sort(arr);
       int total=0,i=0;
       while(i<arr.length && total + (arr[i]*(arr.length-i))<target){
           total+=arr[i];
           i++;
       }
       if(i==arr.length)
           return arr[i-1];
        int diff = target - total;
        int remainCount = arr.length - i;
        int result= diff / remainCount;
       if(Math.abs(diff-(result*remainCount))>Math.abs(diff-((result+1)*remainCount)))
           result++;
       return result;
    }
}
