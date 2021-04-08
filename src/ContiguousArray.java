import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        System.out.println(new ContiguousArray()
        .findMaxLength(new int[]{0,1,1}));
    }
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int cur=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num==0)
                num--;
            cur+=num;
            if(!map.containsKey(cur)){
                map.put(cur,i);
            }else{
                result=Math.max(result,i-map.get(cur));
            }

        }
        return result;
    }
}
