public class Test {

    public static void main(String args[]) {


        System.out.println(canConvertString("mpzzwh","kaeblv",24));
    }

    public static boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length())
            return false;
        int[] diffs=new int[26];
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            int diff=c2-c1;
            if(diff<0){
                diff=26+diff;
            }
            if(diff>0){
                diffs[diff]++;
            }

        }
        for(int i=1;i<Math.min(26,k+1);i++){
            if(diffs[i]>0){
                if((diffs[i]-1)*26+i>k){
                    return false;
                }
                diffs[i]=0;
            }

        }
        for(int i:diffs)
            if(i>0)
                return false;
        return true;

    }

}