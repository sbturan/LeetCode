public class MinimumNumberOfDaysToEatNOranges {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToEatNOranges().minDays(10));
    }
    public int minDays(int n) {
        // 2^a * 3^b +c =n
        int temp1=1;
        int result=n;
        for(int i=0;temp1<=n;i++){
            int temp2=1;
            for(int j=0;(temp1*temp2)<=n;j++){
                result=Math.min(result,i+j+n-temp1*temp2);
                temp2*=2;
            }
            temp1*=3;
        }
        return result+1;
    }
}
