public class SplittingaStringIntoDescendingConsecutiveValues {
    public static void main(String[] args) {
        System.out.println(new SplittingaStringIntoDescendingConsecutiveValues().splitString("10"));
    }
    public boolean splitString(String s) {
        int start=0;
        while(start<s.length() && s.charAt(start)=='0' )
            start++;
        if(start==s.length())
            return false;
        for(int i=start;i<s.length()-1;i++){
            if(helper(i+1,minusOne(s.substring(start,i+1)),s))
                return true;
        }
        return false;
    }
    private boolean helper(int start,String num,String s){
        if(start==s.length())
            return true;
        while(start<s.length() && s.charAt(start)=='0' )
            start++;
        if(start==s.length())
            return "0".equals(num);
        if(num.length()+start>s.length())
            return false;
        int k=0;
        while(k<num.length()&&s.charAt(start+k)==num.charAt(k)){
            k++;
        }
        if(k==num.length()){
            return helper(start+num.length(),minusOne(num),s);
        }
        return false;
    }
    private String minusOne(String num){
        boolean remain=true;
        StringBuilder sb=new StringBuilder(num);
        int i=num.length()-1;
        while(remain && i>-1){
            if(sb.charAt(i)!='0'){
                sb.setCharAt(i,(char)(sb.charAt(i)-1));
                remain=false;
            }else{
                sb.setCharAt(i,'9');
            }
            i--;
        }
        if(remain){
            return "-1";
        }
        int start=0;
        while(start<sb.length()&& sb.charAt(start)=='0')
            start++;
        return sb.substring(Math.min(start,sb.length()-1)).toString();

    }
}
