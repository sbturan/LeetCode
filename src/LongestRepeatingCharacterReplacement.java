

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        System.out.println(l.characterReplacement("ABAB", 2));
    }

    public int characterReplacement(String s, int k) {

        boolean exists[] = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            exists[c - 'A'] = true;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (exists[i]) {
              char cur=(char)(i+'A');
              int temp=k,start=0,end=0;
              while (end<s.length()){
              	  if(chars[end++]!=cur){
              	  	temp--;
				  }
              	  if(temp<0&&chars[start++]!=cur){
              	  	 temp++;
				  }
			  }
              result=Math.max(result,end-start);
            }
        }
        return result;
    }
}
