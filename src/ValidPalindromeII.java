public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
//        String s="aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
//        int i=0,j=s.length()-1;
//        while(s.charAt(i)==s.charAt(j)) {
//            j--;
//            i++;
//        }
//        System.out.println(s.substring(i,j-1));
//        System.out.println(s.substring(i+1,j));
    }

    public boolean validPalindrome(String s) {
        return helper(s, false);
    }

    private boolean helper(String s, boolean deleted) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (deleted)
                    return false;
                return helper(s.substring(i + 1, j+1), true) || helper(s.substring(i, j ), true);
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
