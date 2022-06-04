public class NumberofWaystoSeparateNumbers {
    public static void main(String[] args) {
        String num="5942843479552763655647292931438663227026728857448906120347175455884506";
        System.out.println(num.substring(44,70)+" "+num.substring(18,44));
        System.out.println(new NumberofWaystoSeparateNumbers().compare(44,70,18,44,num));
        //System.out.println(new NumberofWaystoSeparateNumbers().numberOfCombinations(num));
    }

    public int numberOfCombinations(String num) {
        helper(0,0,0,num);
        return result;
    }
    int result=0;
    private void helper(int pos,int mini,int minj,String num){
        if(pos==num.length()){
            result=(int)((result*1l+1)%1000000007);
            return;
        }else if(num.charAt(pos)=='0')
            return;
        else if(!compare(pos,num.length(), mini,minj,num)){

            return;
        }
        for(int i=pos;i<num.length();i++){
            if(i<num.length()-1&&!compare(i+1,num.length(),mini,minj,num)){
                result=(int)((result*1l+1)%1000000007);
                return;
            }
            if(compare(pos,i+1,mini,minj,num)){
                helper(i+1,pos,i+1,num);
            }
        }
    }
    private boolean compare(int i1,int i2,int i3,int i4,String num){
        int l1=i2-i1;
        int l2=i4-i3;
        if(l1!=l2){
            return l1>l2;
        }
        int i=i1;
        int j=i3;
        while(i<i2&& num.charAt(i)==num.charAt(j)){
            i++;
            j++;
        }
        return i==i2|| num.charAt(i)>num.charAt(j);
    }
    private boolean compare(String s1,String s2){
        if(s1.length()!=s2.length()){
            return s1.length()>s2.length();
        }
        int i=0;
        while(i<s1.length()&&s1.charAt(i)==s2.charAt(i)){
            i++;
        }
        return i==s1.length()||s1.charAt(i)>s2.charAt(i);
    }
}
