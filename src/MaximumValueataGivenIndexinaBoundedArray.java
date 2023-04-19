public class MaximumValueataGivenIndexinaBoundedArray {
    public static void main(String[] args) {
        System.out.println(new MaximumValueataGivenIndexinaBoundedArray().maxValue(2,0,798870804));
    }
    public int maxValue(int n, int index, int maxSum) {
        if(maxSum==n)
            return 1;

        int max=2,total=n+1;
        while(total<=maxSum){
             int leftInc=Math.min(index,max-1);
             int rigthInc=Math.min(n-index-1,max-1);
             total+=leftInc+rigthInc+1;
             max++;
        }
        return max-1;
    }
}
