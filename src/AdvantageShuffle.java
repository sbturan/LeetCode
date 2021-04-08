import java.util.Arrays;
import java.util.HashSet;

public class AdvantageShuffle {
    public static void main(String[] args) {
        int[] B = {44, 10, 27, 4, 27, 40, 46, 40, 45, 0, 41, 2, 44, 50, 36, 30, 37, 4, 44, 4, 12, 13, 35, 20, 19, 25, 38, 42, 43, 14, 2, 4, 5, 38, 4, 38, 0, 35, 12, 32, 38, 33, 3, 1, 19, 46, 23, 13, 24, 41};
        long t=System.currentTimeMillis();
        int[] array = new AdvantageShuffle().advantageCount(
                new int[]{28, 47, 45, 8, 2, 10, 25, 35, 43, 37, 33, 30, 33, 20, 33, 42, 43, 36, 34, 3, 16, 23, 15, 10, 19, 42, 13, 47, 0, 21, 36, 38, 0, 5, 3, 28, 4, 20, 14, 5, 19, 22, 29, 17, 3, 16, 35, 0, 26, 0}
                , B
        );
        System.out.println(" aaaaa "+(System.currentTimeMillis()-t));
        Arrays.stream(array).forEach(i-> System.out.print(i+" "));
        System.out.println();
        int count=0;
        for(int i=0;i<B.length;i++){
            if(B[i]<array[i])
                count++;
        }
        System.out.println(count);

    }
    public int[] advantageCount(int[] A, int[] B) {
         Arrays.sort(A);
         HashSet<Integer> set=new HashSet<>();
         int result[]=new int[A.length];
         for(int i=0;i<B.length;i++){
             int index=Arrays.binarySearch(A,B[i]);
             if(index<0){
                 index=-index-1;
             }
             while(index<A.length && (set.contains(index)||B[i]>=A[index])){
                 index++;
             }
             if(index==A.length){
                 index=0;
                 while( set.contains(index)){
                     index++;
                 }
             }
             result[i]=A[index];
             set.add(index);
         }
         return result;
    }
}
