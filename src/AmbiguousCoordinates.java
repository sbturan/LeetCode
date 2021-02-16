import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {
    public static void main(String[] args) {
        System.out.println(new AmbiguousCoordinates()
                .ambiguousCoordinates("(123)"));
    }

    public List<String> ambiguousCoordinates(String S) {
        int zeroCounts[] = new int[S.length()];
        for (int i = 1; i < S.length() - 1; i++) {
            zeroCounts[i] = zeroCounts[i - 1] + (S.charAt(i) == '0' ? 1 : 0);
        }
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(S);
        for (int i = 1; i < S.length() - 2; i++) {
            int rightCharCount = S.length() - 2 - i;
            if ((i > 1 && zeroCounts[i] == i)
                    || (i < S.length() - 1 && zeroCounts[S.length() - 1] - zeroCounts[i] == rightCharCount))
                continue;
            List<String> left = getOnePart(S, 1, i);
            List<String> right = getOnePart(S, i + 1, S.length() - 2);
            if (i == 1 || sb.charAt(1) != '0')
                left.add(sb.substring(1, i + 1));
            if (i == S.length() - 3 || sb.charAt(i + 1) != '0')
                right.add(sb.substring(i + 1, S.length() - 1));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        return result;
    }

    private List<String> getOnePart(String s, int start, int end) {
        List<String> result = new ArrayList<>();
        if (s.charAt(end) == '0' || end == start) {
            return result;
        }
        if (s.charAt(start) == '0') {
            result.add(s.substring(start, start + 1) + "." + s.substring(start + 1, end + 1));
            return result;
        }
        for (int i = start + 1; i <= end; i++) {
            result.add(s.substring(start, i) + "." + s.substring(i, end+1));
        }
        return result;
    }
}
