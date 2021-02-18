import java.util.HashSet;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {
    public static void main(String[] args) {
        System.out.println(new SplitaStringIntotheMaxNumberofUniqueSubstrings()
        .maxUniqueSplit("wwwzfvedwfvhsww"));
    }

    public int maxUniqueSplit(String s) {
        return helper(s, 0, new HashSet<>());
    }

    private int helper(String s, int start, HashSet<String> subs) {
        if (start == s.length())
            return 0;
        int result = -1;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (!subs.contains(substring)) {
                subs.add(substring);
                result = Math.max(result, 1 + helper(s, end, subs));
                subs.remove(substring);
            }
        }
        return result;
    }
}
