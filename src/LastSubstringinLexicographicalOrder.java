public class LastSubstringinLexicographicalOrder {
    public static void main(String[] args) {
        System.out.println(new LastSubstringinLexicographicalOrder()
        .lastSubstring("tatt"));
    }
    public String lastSubstring(String s) {
        int maxIndex = s.length();
        char maxChar = 'a';
        for(int i=s.length()-1;i>-1;i--){
            char c = s.charAt(i);
            if(c >maxChar){
                maxChar= c;
                maxIndex=i;
            }else if(c==maxChar){
                int j=i;
                int k=maxIndex;
                while(j<maxIndex && k<s.length() && s.charAt(j)==s.charAt(k)){
                    j++;
                    k++;
                }
                if(j==maxIndex || k==s.length()||s.charAt(j)>s.charAt(k)){
                    maxIndex=i;
                }
            }
        }
        return s.substring(maxIndex);
    }
}

