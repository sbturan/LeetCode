public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        System.out.println(new PartitionArrayIntoThreePartsWithEqualSum()
        .canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }
    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for (int i : arr)
            total += i;
        if (total % 3 != 0)
            return false;
        int i = 1;
        int curTotal = arr[i++];
        while(curTotal!=total/3 && i<arr.length){
            curTotal+=arr[i++];
        }
        if(i>arr.length-3)
            return false;
        int j=i;
        curTotal=arr[j++];
        while(curTotal!=total/3 && j<arr.length){
            curTotal+=arr[j++];
        }
        if(j>arr.length-2)
            return false;
        return true;

    }
}
