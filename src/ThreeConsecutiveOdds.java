public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
       int cons=0;
       for(int i:arr){
           if(i%2==0)
               cons=0;
           else
               cons++;
           if(cons==3)
               return true;
       }
       return false;
    }
}
