import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        System.out.println(new PancakeSorting().pancakeSort(new int[]{3,1,2}));
    }
    public List<Integer> pancakeSort(int[] arr) {
        int n=arr.length;
        int[] indexes=new int[n+1];
        for(int i=0;i<n;i++){
            indexes[arr[i]]=i;
        }
        List<Integer> result=new ArrayList<>();
        for(int i=n;i>1;i--){
            int indexOf=indexes[i];
            if(indexOf!=i-1){
                int diff=i-1-indexOf;
                for(int j=1;j<=n;j++){
                    if(indexes[j]<=indexOf){
                        indexes[j]+=diff;
                    }else{
                        indexes[j]-=(indexOf+1);
                        indexes[j]=diff-1-indexes[j];
                    }
                }
                result.add(indexOf+1);
                result.add(i);
            }
        }
        return result;
    }
}
