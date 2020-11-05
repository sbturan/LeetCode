public class StringWithoutAAAorBBB {
    public static void main(String[] args) {
        System.out.println(new StringWithoutAAAorBBB().strWithout3a3b(18,23));
    }
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb=new StringBuilder();
        int countA = A, countB = B, dif=Math.abs(A-B);
        if(countB>countA && countB>1){
          sb.append("bb");
          countB-=2;
        }
        while(countA>0 || countB>0){
           if(countA>0){
               sb.append("a");
               countA--;
               if(A>B && dif>0&&countA>0){
                   sb.append("a");
                   countA--;
                   dif--;
               }
           }
           if(countB>0){
               sb.append("b");
               countB--;
               if(B>A &&dif>0&& countB>0){
                   sb.append("b");
                   countB--;
                   dif--;
               }
           }
        }
        return sb.toString();
    }
}
