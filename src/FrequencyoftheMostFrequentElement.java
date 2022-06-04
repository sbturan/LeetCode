import java.util.Arrays;

public class FrequencyoftheMostFrequentElement {
    public static void main(String[] args) {
        System.out.println(new FrequencyoftheMostFrequentElement().maxFrequency(new int[]{1,6,12,13,14},3));
    }
    public int maxFrequency(int[] nums, int k) {
        if(nums.length==1)
            return 1;
        Arrays.sort(nums);
        int i=0,j=1;
        int cur=nums[1]-nums[0];
        int result=1;
        while(j<nums.length&&i<nums.length){
            while(cur<=k&&j<nums.length){
                result=Math.max(result,j-i+1);
                j++;
                if(j< nums.length)
                cur+=(nums[j]-nums[j-1])*(j-i);
            }
            if(j==nums.length)
                return result;
            cur-=nums[j]-nums[i];
            i++;
        }
        return result;
    }
}
