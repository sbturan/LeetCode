

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare(
                "nzp#o#g"
                ,"b#nzp#o#g"));
    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (i > -1 || j > -1) {
            int count = 0;
            while (i > -1 && S.charAt(i) == '#') {
                count = 0;
                while (i > -1 && S.charAt(i) == '#') {
                    count++;
                    i--;
                }
                while(i>-1 && count>0) {
                    if (S.charAt(i) == '#') {
                        count+=2;
                    }
                    i--;
                    count--;
                }
            }
            while (j > -1 && T.charAt(j) == '#') {
                count = 0;
                while (j > -1 && T.charAt(j) == '#') {
                    count++;
                    j--;
                }
                while(j>-1 && count>0){
                    if(T.charAt(j)=='#'){
                       count+=2;
                    }
                    j--;
                    count--;
                }
            }

            if (i < 0 && j < 0)
                return true;
            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j))
                return false;
            i--;
            j--;
        }
        return true;
    }
}
