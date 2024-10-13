import java.util.*;

public class NumberOfValidWordsForEachPuzzle {
    public static void main(String[] args) {
        System.out.println(new NumberOfValidWordsForEachPuzzle().findNumOfValidWords(
                new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}
        ));
    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        long[] map=new long[26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char c=words[i].charAt(j);
                map[c-'a']|= 1l<<j;
            }
        }
        List<Integer> result=new ArrayList<>();
        for(String p:puzzles){
            boolean[] chars=new boolean[26];
            for(Character c:p.toCharArray()){
                chars[c-'a']=true;
            }
            long cur=map[p.charAt(0)-'a'];
            for(int i=0;i<26&&cur>0;i++){
                char cc=(char)(i+'a');
                if(!chars[cc-'a']){
                    long temp=map[cc-'a'];
                    cur = cur & ~temp;
                }
            }
            result.add(Long.bitCount(cur));
        }
        return result;
    }
}
