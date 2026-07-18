import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindtheLongestEqualSubarray {
    public static void main(String[] args) {
        System.out.println(new FindtheLongestEqualSubarray().longestEqualSubarray(Arrays.asList(9,5,1,4,2,3,4,13,5,2,7,2,2,14),4));
    }
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int result=0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.size();i++){
            int cur=nums.get(i);
            map.putIfAbsent(cur,new ArrayList<>());
            map.get(cur).add(i);
            List<Integer> curList=map.get(cur);
            if(curList.size()>1){
                int j=curList.size()-1;
                int diff=0;
                while(diff<=k&&j>-1){
                    result=Math.max(result,curList.size()-j);
                    j--;
                    if(j>-1)
                    diff+=curList.get(j+1)-curList.get(j)-1;

                }
            }
        }
        return result;
    }
}
