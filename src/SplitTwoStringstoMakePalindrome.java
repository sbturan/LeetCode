public class SplitTwoStringstoMakePalindrome {
    public static void main(String[] args) {
        System.out.println(new SplitTwoStringstoMakePalindrome()
                .checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd"
                        , "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
    }

    public boolean checkPalindromeFormation(String a, String b) {
        int start = 0, end = a.length() - 1;

        while (start < end && a.charAt(start) == b.charAt(end)) {
            start++;
            end--;
        }
        boolean answer = (checkPalindrome(start, end, b) ||
                checkPalindrome(start, end, a));
        if (!answer) {
            start = 0;
            end = a.length() - 1;
            while (start < end && b.charAt(start) == a.charAt(end)) {
                start++;
                end--;
            }
            answer = (checkPalindrome(start, end, b) ||
                    checkPalindrome(start, end, a));
        }
        return answer;
    }


    private boolean checkPalindrome(int start, int end, String target) {
        while (start < end && target.charAt(start) == target.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
