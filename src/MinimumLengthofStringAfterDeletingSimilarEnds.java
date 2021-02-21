public class MinimumLengthofStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        System.out.println(new MinimumLengthofStringAfterDeletingSimilarEnds()
        .minimumLength("a"));
    }
    public int minimumLength(String s) {

       int i=-1,j=s.length();
       while(i<j){
           i++;
           j--;
           if(i<j && s.charAt(i)==s.charAt(j)){
                while(j>i && s.charAt(j)==s.charAt(j-1))
                    j--;
               while(j>i && s.charAt(i)==s.charAt(i+1))
                   i++;
           }else{
               return j-i+1;
           }

       }
       if(j==i)
           j--;
       return j-i+1;
    }
}
