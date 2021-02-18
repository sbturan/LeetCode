import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class LongestWordinDictionarythroughDeleting {
    public static void main(String[] args) {
        String[] a = {"abvd", "aa"};
        Arrays.sort(a);
        Arrays.stream(a).forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("a".compareTo("aa"));
    }

    public String findLongestWord(String s, List<String> d) {
        TreeSet<Integer>[] map = new TreeSet[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c - 'a'] == null) {
                map[c - 'a'] = new TreeSet();
            }
            map[c - 'a'].add(i);
        }
        String result = "";
        for (String cur : d) {
            if (compare(cur, map) &&
                    (cur.length() > result.length() ||
                            (cur.length() == result.length() && cur.compareTo(result) < 0))) {
                result = cur;
            }
        }
        return result;
    }

    private boolean compare(String a, TreeSet<Integer>[] map) {
        int curIndex = -1;
        for (char c : a.toCharArray()) {
            TreeSet<Integer> set = map[c - 'a'];
            if(set==null)
                return  false;
            Integer next = set.higher(curIndex);
            if (next == null)
                return false;
            curIndex = next;
        }
        return true;
    }
}
