public class NumberofSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        System.out.println(new NumberofSubstringsContainingAllThreeCharacters()
                .numberOfSubstrings("abacbbc"));
    }

    public int numberOfSubstrings(String s) {
        int result = 0;
        int[] counts = new int[3];
        int i = 0, j = 0;
        while (i < s.length()) {
            while (j < s.length() && (counts[0] == 0 || counts[1] == 0 || counts[2] == 0)) {
                counts[s.charAt(j) - 'a']++;
                j++;
            }
            int k = i;
            while (k < s.length() && (counts[0] > 0 && counts[1] > 0 && counts[2] > 0)) {
                result += s.length() - j + 1;
                counts[s.charAt(k) - 'a']--;
                k++;
            }
            i= Math.max(i+1,k);
        }
        return result;
    }
}
