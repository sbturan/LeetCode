import java.util.HashMap;

public class NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers {
    public static void main(String[] args) {
        System.out.println(new NumberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers()
                .numTriplets(new int[]{43024,99908},new int[]{1864}));
    }
    public int numTriplets(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> arr1=new HashMap<>();
        HashMap<Integer,Integer> arr2=new HashMap<>();
        for(int i:nums1){
            arr1.put(i,arr1.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            arr2.put(i,arr2.getOrDefault(i,0)+1);
        }
        int result=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=i+1;j<nums1.length;j++){
                int val= (int)Math.sqrt((long)nums1[i]*nums1[j]);
                if(val*val==nums1[i]*nums1[j] && arr2.containsKey(val)){
                    result+=arr2.get(val);
                }
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i+1; j < nums2.length; j++) {
                int val= (int)Math.sqrt((long)nums2[i]*nums2[j]);
                if(val*val==nums2[i]*nums2[j] && arr1.containsKey(val)){
                    result+=arr1.get(val);
                }
            }
        }
        return result;
    }
}
