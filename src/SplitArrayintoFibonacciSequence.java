import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence {
    public static void main(String[] args) {
        System.out.println(new SplitArrayintoFibonacciSequence()
                .splitIntoFibonacci("020406"));
    }
    public List<Integer> splitIntoFibonacci(String S) {

        int first=0,second=0;
        int maxI=S.charAt(0)=='0'?1:Math.min(10, S.length());
        for(int i=0;i<maxI;i++){
            first=first*10+Integer.valueOf(S.charAt(i)+"");
            second=0;
            int maxJ=Math.min(10, S.length());
            for(int j=i+1;j<maxJ;j++){
                if (S.charAt(i+1) == '0' && j > i+1) break;
                if(Math.max(i+1,j-i)>S.length()-j-1){
                    j=S.length();
                    break;
                }
                ArrayList<Integer> result=new ArrayList<>();
                result.add(first);
                second=second*10+Integer.valueOf(S.charAt(j)+"");
                result.add(second);
                if(helper(S,j+1,result)){
                    return result;
                }
            }
        }
        return new ArrayList<>();
    }
    private boolean helper(String s,int index,List<Integer> result){
        if(index==s.length()){
            return true;
        }
        int target=result.get(result.size()-1)+result.get(result.size()-2);
        if(s.substring(index).indexOf(target+"")==0){
            result.add(target);
            if(helper(s,index+(target+"").length(),result)){
                return true;
            }
        }
        return false;
    }
}
