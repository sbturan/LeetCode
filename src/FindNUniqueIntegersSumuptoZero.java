public class FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
      int[] result=new int[n];
      int index=0;
      for(int i=-n/2;i<=n/2;i++){
          if(i==0){
             if(n%2==1){
                 result[index++]=i;
             }
          }else{
              result[index++]=i;
          }
      }
      return result;
    }
}
