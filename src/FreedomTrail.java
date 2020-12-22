import java.util.ArrayList;

public class FreedomTrail {
    public static void main(String[] args) {

        System.out.println(new FreedomTrail().findRotateSteps("nayngiiiiiiiil"
                ,"yyynnnnnnlllggg"));
                System.out.println(new FreedomTrail().findRotateSteps("zvyii"
                ,"iivyz"));
        System.out.println(new FreedomTrail().findRotateSteps("ababcab"
                ,"acbaacba"));
    }
    public int findRotateSteps(String ring, String key) {
        int result = 0;
        ArrayList<Integer>[] indexes = new ArrayList[26];
        for(int i=0;i<ring.length();i++){
            char c=ring.charAt(i);
            if(indexes[c-'a']==null)
                indexes[c-'a']=new ArrayList();
            indexes[c-'a'].add(i);
        }

        return helper(ring,key,0,0,indexes,new Integer[ring.length()][key.length()]);
    }
    public int helper(String ring,String key,int indexRing,int indexKey,ArrayList<Integer>[] indexes,Integer[][] dp){
        if(indexKey== key.length())
            return 0;
        if(dp[indexRing][indexKey]!=null)
            return dp[indexRing][indexKey];
        ArrayList<Integer> index=indexes[key.charAt(indexKey)-'a'];
        int min=Integer.MAX_VALUE;
        for(Integer i:index){
           int diff= Math.abs(indexRing-i);
           diff=Math.min(diff,ring.length()-diff)+1;
           diff+=helper(ring, key, i, indexKey+1, indexes, dp);
           min=Math.min(min,diff);
        }
        dp[indexRing][indexKey]=min;
        return min;
    }
}
