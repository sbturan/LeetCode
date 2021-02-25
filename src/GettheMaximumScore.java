import java.util.HashMap;

public class GettheMaximumScore {
    public static void main(String[] args) {
        System.out.println(new GettheMaximumScore()
                .maxSum(new int[]{2,4,5,8,10}, new int[]{4,6,8,9}));
    }

    public int maxSum(int[] nums1, int[] nums2) {
        HashMap<Integer, Long> map1 = new HashMap<>();
        long total=0;
        for (int i = 0; i < nums1.length; i++) {
            total+=nums1[i];
            map1.put(nums1[i], total);
        }
        long minTotal=0;
        int prevCommon=-1;
        long leftTotal=0;
        long lastCommonPrefix=0;
        for (int i = 0; i < nums2.length; i++) {
            leftTotal+=nums2[i];
            if (map1.containsKey(nums2[i])) {
                Long b = map1.get(nums2[i]);
                if(prevCommon==-1){
                    minTotal+=Math.min(leftTotal, b);
                }else{
                    minTotal+=Math.min(leftTotal-lastCommonPrefix,b-map1.get(nums2[prevCommon]));
                }
                prevCommon=i;
                lastCommonPrefix=leftTotal;
            }
        }
        if(prevCommon==-1){
            return (int)(Math.max(leftTotal, map1.get(nums1[nums1.length-1]))%1000000007);
        }
        long result=(leftTotal+map1.get(nums1[nums1.length-1])-minTotal);
        result-=Math.min(leftTotal-lastCommonPrefix,map1.get(nums1[nums1.length-1])-map1.get(nums2[prevCommon]));
        return (int)(result%1000000007);
    }
}
