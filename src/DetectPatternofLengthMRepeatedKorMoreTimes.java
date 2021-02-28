import java.util.HashMap;

public class DetectPatternofLengthMRepeatedKorMoreTimes {
    public static void main(String[] args) {
        System.out.println(new DetectPatternofLengthMRepeatedKorMoreTimes()
        .containsPattern(new int[]{1,2,1,2,1,3},2,3));
    }
    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m * k)
            return false;
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder curStr = new StringBuilder();
        for (int i = arr.length-1; i >-1; i--) {
              curStr.insert (0,","+arr[i]);
              if(i<=arr.length-m){
                  String cur=curStr.substring(0,2*m);
                  int count=map.getOrDefault(cur,0)+1;
                  if(count==k)
                      return true;
                  map.put(cur,count);
              }
        }
        return false;
    }
}
