public class FormArraybyConcatenatingSubarraysofAnotherArray {
    public static void main(String[] args) {
        System.out.println(new FormArraybyConcatenatingSubarraysofAnotherArray()
                .canChoose(new int[][]{{6636698,4693069,-2178984,-2253405,-2732131,8550889,-2324014,-2561263},{-8973571,-9146179,7704305,-1063430,-6569826},{2791091},{-9691134,651171,9835817,4163881,4944714,8166788,-9025553,-9250995,1599781}},
                        new int[]{8550889,-2178984,6636698,4693069,-2178984,-2253405,-2732131,8550889,-2324014,-2561263,-2324014,8550889,-8973571,-9146179,7704305,-1063430,-6569826,2791091,-9691134,651171,9835817,4163881,4944714,8166788,-9025553,-9250995,1599781}));
    }
    public boolean canChoose(int[][] groups, int[] nums) {
        int j=nums.length-1;
        for(int i=groups.length-1;i>-1;i--){
            int[] curGroup=groups[i];
            int k=curGroup.length-1;
            boolean found=false;
            while(j>-1&&!found){
                int jj=j;
                int kk=k;
                while(jj>-1&&kk>-1&&nums[jj]==curGroup[kk]){
                    jj--;
                    kk--;
                }
                if(kk==-1){
                    found=true;
                    j=jj+1;
                }

                j--;
            }

            if(!found)
                return false;
        }
        return true;
    }
}
