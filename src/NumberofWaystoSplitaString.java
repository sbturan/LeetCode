public class NumberofWaystoSplitaString {
    public static void main(String[] args) {
        System.out.println(new NumberofWaystoSplitaString()
        .numWays("111"));
    }
    public int numWays(String s) {
        int mod=1000000007;
       int oneCount=0;
       for(char c:s.toCharArray()){
           oneCount+=(c-'0');
       }
       if(oneCount % 3!=0)
           return 0;
       if(oneCount==0){
           if(s.length()<3)
               return 0;
           long extraZero=s.length()-3;
           return (int)(((extraZero+1)*(extraZero+2)/2)%mod);
       }
       int eachOneCount=oneCount/3;
       int i=0;
       int count=0;

       while(count<eachOneCount){
           count+=(s.charAt(i++)-'0');
       }

       int j=i;
       while(s.charAt(j)=='0'){
           j++;
       }
       long leftZeroCount=j-i;
       count=0;
       i=s.length()-1;
        while(count<eachOneCount){
            count+=(s.charAt(i--)-'0');
        }
        j=i;
        while(s.charAt(j)=='0'){
            j--;
        }
        long rightZeroCount=i-j;
        return (int)(((leftZeroCount+1)*(rightZeroCount+1))%mod);
    }
}
