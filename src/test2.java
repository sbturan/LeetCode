import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class test2 {
    public static void main(String[] args) {
        KthLargest k = new test2().new KthLargest(2, new int[]{0});
        System.out.println(k.add(-1));
		System.out.println(k.add(1));
		System.out.println(k.add(-2));
		System.out.println(k.add(-4));
		System.out.println(k.add(3));
    }

    class KthLargest {
        LinkedList<Integer> list;

        public KthLargest(int k, int[] nums) {
        	if(nums.length<k){
                int[] nums2=new int[k];
                for(int m=0;m<k;m++)
                    if(m<nums.length){
                        nums2[m]=nums[m];
                    }else{
                        nums2[m]=Integer.MIN_VALUE;
                    }
              nums=nums2;
            }

            Arrays.sort(nums);
            int i = nums.length - 1;
            list = new LinkedList<Integer>();
            while (k > 0 && i>-1) {
                list.add(nums[i]);
                i--;
                k--;
            }
            Collections.reverse(list);
        }

        public int add(int val) {
            if (val < list.getFirst())
                return list.getFirst();
            int index = Collections.binarySearch(list, val);
            if (index < 0)
                index = -index - 1;
            list.add(index, val);
            list.removeFirst();
            return list.getFirst();
        }
    }

    public boolean isOneBitCharacter(int[] bits) {
        if (bits[bits.length - 1] == 1)
            return false;
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i++;
            }
            i++;
        }
        return i == bits.length - 1;
    }
}
