import java.util.ArrayList;

public class LargestValuesFromLabels {
    public static void main(String[] args) {
        System.out.println(new LargestValuesFromLabels()
                .largestValsFromLabels(
                        new int[]{3,2,3,2,1},
                        new int[]{1,0,2,2,1},
                        2,1
                ));
    }
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int max=Integer.MIN_VALUE;
        ArrayList<Integer>[] arr=new ArrayList[20001];
        for(int i=0;i<values.length;i++){
            if(arr[values[i]]==null)
                arr[values[i]]=new ArrayList();
            arr[values[i]].add(labels[i]);
            max=Integer.max(max,values[i]);
        }
        int[] labelCounts=new int[20001];
        int i=max;
        int result=0;
        while(i>-1 && num_wanted>0){
            ArrayList<Integer> cur = arr[i];
            if(cur !=null&& cur.size()>0){
                int j=0;
              while(j<cur.size()&& num_wanted>0){
                  if(labelCounts[cur.get(j)]<use_limit){
                      result+=i;
                      labelCounts[cur.get(j)]++;
                      num_wanted--;
                  }
                  j++;
              }
          }
            i--;
        }
        return  result;
    }
}
