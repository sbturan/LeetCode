import java.util.Arrays;
import java.util.Comparator;

public class RearrangeWordsinaSentence {
    public static void main(String[] args) {
        System.out.println(new RearrangeWordsinaSentence().arrangeWords("L"));
    }
    public String arrangeWords(String text) {
        String[] split = text.toLowerCase().split(" ");
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        String join = String.join(" ", split);
        join=String.valueOf((char)(join.charAt(0)-32)).concat(join.substring(1));
        return join;
    }
}
