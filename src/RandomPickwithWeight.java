import java.util.Random;
import java.util.TreeMap;

public class RandomPickwithWeight {
    public static void main(String[] args) {
        Solution solution = new RandomPickwithWeight().new Solution(new int[]{1});
        System.out.println(solution.pickIndex());
    }
    class Solution {

        TreeMap<Integer,Integer> map;
        int length=0;
        Random random;
        public Solution(int[] w) {
            random = new Random();
            map=new TreeMap<>();
            for(int i=0;i<w.length;i++){
              map.put(length,i);
                length+=w[i];
            }
        }

        public int pickIndex() {

            int index = random.nextInt(length);
            return map.get(map.lowerKey(index+1));
        }
    }
}
