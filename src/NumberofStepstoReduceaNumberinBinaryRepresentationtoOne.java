public class NumberofStepstoReduceaNumberinBinaryRepresentationtoOne {
    public static void main(String[] args) {
        System.out.println(new NumberofStepstoReduceaNumberinBinaryRepresentationtoOne()

                .numSteps("1011001"));
    }
    public int numSteps(String s) {
        char[] chars = s.toCharArray();
        int step=0;
        int right=s.length()-1;
        if(s.equals("10") || s.equals("1"))
            return s.length()-1;
       while(true){
           while(chars[right]=='0'){
               right--;
               step++;
           }
           int i=right;
           while(i>-1 && chars[i]=='1'){
               chars[i]='0';
               i--;
           }
           step++;
           if(i==-1){
               return right+1+step;
           }
           chars[i]='1';
       }
    }
}
