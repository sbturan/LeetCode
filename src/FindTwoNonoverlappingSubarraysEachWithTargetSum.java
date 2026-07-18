public class FindTwoNonoverlappingSubarraysEachWithTargetSum {
    public static void main(String[] args) {
        System.out.println(new FindTwoNonoverlappingSubarraysEachWithTargetSum()
                .minSumOfLengths(new int[]{3,2,2,4,3},3));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int min1=arr.length;
        int min2=arr.length;
        int i=0,j=0;
        int total=arr[0];
        while(j<arr.length){
            if(total==target){
                int l=j-i+1;
                if(l<min1){
                    min2=min1;
                    min1=l;
                }else if(l<min2){
                    min2=l;
                }
                j++;
                i=j;
                total=0;
            }else if (total>target){
                total-=arr[i++];
            }else{
                total+=arr[++j];
            }
        }
        if(min2!=arr.length)
            return min1+min2;
        return -1;
    }
}
