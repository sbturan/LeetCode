public class MinimumInsertionstoBalanceaParenthesesString {
    public static void main(String[] args) {
        System.out.println(new MinimumInsertionstoBalanceaParenthesesString()
        .minInsertions("()()()()()("));
    }
    public int minInsertions(String s) {
        int result = 0;
        int i = 0;
        int flag = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                flag++;
            } else {
                if (i == s.length() - 1 || s.charAt(i + 1) == '(') {
                    result++;
                }else {
                    i++;
                }
                flag--;
            }
            if (flag < 0) {
                result += 1;
                flag=0;
            }
            i++;
        }
        return result + (flag * 2);
    }
}
