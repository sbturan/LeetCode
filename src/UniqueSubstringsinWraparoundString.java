public class UniqueSubstringsinWraparoundString {
    public static void main(String[] args) {
        System.out.println(new UniqueSubstringsinWraparoundString().findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }
    public int findSubstringInWraproundString(String p) {
        int[] maxSubs=new int[26];
        int i=0;
        int result=0;
        while(i<p.length()){
            int j=i+1;
            while(j<p.length() && (p.charAt(j)-p.charAt(j-1)==1 || p.charAt(j)-p.charAt(j-1)==-25)){
                j++;
            }
            int diff = j - i;
            if(diff >maxSubs[p.charAt(i)-'a']){
                result+=diff*(diff+1)/2;
                for(int k=0;k<diff;k++){
                    int curChar=p.charAt(i+k)-'a';
                    if(maxSubs[curChar]>0){
                        if(maxSubs[curChar]>diff-k){
                            result-=(diff-k)*(diff-k+1)/2;
                            k+=diff-k;
                        }else{
                            result-=(maxSubs[curChar]);//*(maxSubs[curChar]+1)/2;
                            //k+=maxSubs[curChar];
                            maxSubs[curChar]= diff-k;
                        }
                    }else{
                        maxSubs[curChar]= diff-k;
                    }
                }
            }
            i=j;
        }
        return result;
    }
}
