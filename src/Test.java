import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[]) {
        List<Integer> weight=new ArrayList<>();
        weight.add(3);
        weight.add(2);weight.add(3);
        getTotalImbalance(weight);

    }


    public static long getTotalImbalance(List<Integer> weight) {
        long result=0;
        int[] mins=new int[weight.size()];
        mins[mins.length-1]=weight.get(mins.length-1);
        for(int i=mins.length-2;i>-1;i--){
            mins[i]=Math.min(mins[i+1], weight.get(i));
        }
        for(int i=0;i<weight.size();i++){
            int min=weight.get(i),max=weight.get(i);
            for(int j=i;j<weight.size();j++){
                min=Math.min(min, weight.get(j));
                max=Math.max(max, weight.get(j));
                if(min==mins[j]){
                    result+=(max-min)*(weight.size()-j);
                    break;
                }
                result+=max-min;
            }
        }
        return result;

    }
}