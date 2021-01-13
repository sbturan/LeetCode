public class CheckArrayFormationThroughConcatenationSolution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
       Integer[] map=new Integer[101];
       for(int i=0;i<pieces.length;i++){
           map[pieces[i][0]]=i;
       }
       int i=0;
       while(i<arr.length){
         Integer index=map[arr[i]];
         if(index==null){
             return false;
         }
         int k=i;
         for(int j=0;j<pieces[index].length;j++){
             if(pieces[index][j]!=arr[k])
                 return false;
             k++;
         }
         i=i+pieces[index].length;
       }
       return true;
    }
}
