import java.util.Arrays;

public class StoneGameVI {
    public static void main(String[] args) {
        System.out.println(new StoneGameVI().stoneGameVI(
                new int[]{2,4,3},
                new int[]{1,6,7}
        ));
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
      int[][] arr=new int[aliceValues.length][3];
      for(int i=0;i<aliceValues.length;i++){
          arr[i]=new int[]{aliceValues[i]+bobValues[i],aliceValues[i],bobValues[i]};
      }
        Arrays.sort(arr, (o1, o2) -> o2[0]-o1[0]);
      int total=0;
      for(int i=0;i<arr.length;i++){
          if(i%2==0){
              total+=arr[i][1];
          }else{
              total-=arr[i][2];
          }
      }
      return total>0?1:total==0?0:-1;
    }
}
