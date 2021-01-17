public class MinimumDeletionstoMakeStringBalanced {
    public static void main(String[] args) {
        System.out.println(new MinimumDeletionstoMakeStringBalanced().minimumDeletions("aabbbbaabababbbbaaaaaabbababaaabaabaabbbabbbbabbabbababaabaababbbbaaaaabbabbabaaaabbbabaaaabbaaabbbaabbaaaaabaa"));
    }

    public int minimumDeletions(String s) {
        int totalA=0,curB=0;
        for (int i = 0; i < s.length(); i++) {
            totalA+=1-(s.charAt(i) - 'a');
        }
        int result = s.length()-totalA;
        if(totalA==s.length())
            return 0;
        for (int i = 0; i < s.length(); i++) {
            result = Math.min(result, curB+totalA);
            totalA-=1-(s.charAt(i) - 'a');
            curB+=(s.charAt(i) - 'a');
        }
        return result;
    }
}

