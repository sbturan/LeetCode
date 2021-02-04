import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String S) {
        Integer[] lastIndexes = new Integer[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexes[S.charAt(i) - 'a'] = i;
        }
        int curLength = 0;
        int curLastIndex = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (i > curLastIndex) {
                result.add(curLength);
                curLength = 0;
            }
            curLength++;
            curLastIndex = Math.max(curLastIndex, lastIndexes[S.charAt(i) - 'a']);
        }
        result.add(curLength);
        return result;
    }
}
