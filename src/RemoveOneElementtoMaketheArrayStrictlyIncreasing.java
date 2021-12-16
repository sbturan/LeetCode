public class RemoveOneElementtoMaketheArrayStrictlyIncreasing {
    public static void main(String[] args) {
        System.out.println(new RemoveOneElementtoMaketheArrayStrictlyIncreasing().canBeIncreasing(new int[]{89,384,691,680,111,756}));
    }
    public boolean canBeIncreasing(int[] nums) {
        if(nums.length<3)
            return true;
        int index=-1;
        for(int i=0;i<nums.length-1&&index==-1;i++){
            if(nums[i]>=nums[i+1])
                index=i;
        }
        if(index==-1)
            return true;

        int temp=nums[index];
        nums[index]=-1;
        if(increased(nums))
            return true;
        nums[index]=temp;
        if(index==nums.length-1)
            return false;
        nums[index+1]=-1;
        return increased(nums);
    }
    private boolean increased(int[] arr){

        int first=0,second=1;

        while(second<arr.length){
            if(arr[second]==-1)
                second++;
            if(arr[first]==-1){
                first++;
                if(first==second)
                second++;
            }


            if(second<arr.length && arr[second]<=arr[first]){
                return false;
            }
            first++;
            second++;
        }
        return true;
    }
}
