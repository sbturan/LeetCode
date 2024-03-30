public class GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        System.out.println(new GetEqualSubstringsWithinBudget()
                .equalSubstring("abcd","bcdf",3));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int[] costs=new int[s.length()];
        for(int i=0;i<s.length();i++){
            costs[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int i=0,j=0;
        int cur=0;
        int result=0;
        while(j<costs.length){
            if(cur<=maxCost){
                cur+=costs[j];
                j++;

            }else{
                cur-=costs[i];
                i++;
            }
            if(cur<=maxCost){
                result=Math.max(result,j-i);
            }
        }
        return result;
    }
}
