public class DecodeWays2 {
    public static void main(String[] args) {
        System.out.println(new DecodeWays2().numDecodings("*3"));
    }
    public int numDecodings(String s) {
        return (int)(helper(s,new long[s.length()],0)%100000007);
    }
    private long helper(String s,long[] dp ,int index){

        if(index==s.length()){
            return 1;
        }
        if(dp[index]>0)
            return dp[index];
        char c1=s.charAt(index);
        if(c1=='0')
            return 0;
        if(index==s.length()-1){
            if(c1=='*')
                return 9;
            return 1;
        }
        char c2=s.charAt(index+1);
        long result=helper(s,dp,index+1);
        if(c1=='*'){
            result*=9;
        }
        String t=""+c1+c2;
        if(t.equals("1*")){
            result+=9*(helper(s,dp,index+2));
        }else if(t.equals("2*")){
            result+=6*(helper(s,dp,index+2));
        }else if(c1=='*'&&c2!='*'&&Integer.valueOf(c2)<7){
            result+=2*(helper(s,dp,index+2));
        }else if(t.equals("**")){
            result+=15*(helper(s,dp,index+2));
        }else if(c1!='*'&&c2!='*'&&Integer.valueOf(t)<27){
            result+=(helper(s,dp,index+2));
        }
        dp[index]=result;
        return result;
    }
}
