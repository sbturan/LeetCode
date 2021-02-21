public class MinimumSwapstoMakeStringsEqual {
    public static void main(String[] args) {
        System.out.println(new MinimumSwapstoMakeStringsEqual()
                .minimumSwap("xyyyyx", "xxxxyy"
                ));
        System.out.println(new MinimumSwapstoMakeStringsEqual()
                .minimumSwap("xxxx", "yyyy"
                ));
        System.out.println(new MinimumSwapstoMakeStringsEqual()
                .minimumSwap("xxyyxyxyxx","xyyxyxxxyx"
                ));


    }

    public int minimumSwap(String s1, String s2) {
        int[] count1 = new int[2];
        int[] count2 = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            count1[0] += 'y' - s1.charAt(i);
            count1[1] += 1 - ('y' - s1.charAt(i));
            count2[0] += 'y' - s2.charAt(i);
            count2[1] += 1 - ('y' - s2.charAt(i));
        }
        if ((count1[0] + count2[0]) % 2 == 1 || (count1[1] + count2[1]) % 2 == 1)
            return -1;

        int[] dept = new int[2];
        int result = 0;
        if (count1[0] > count2[0]) {
            dept[0] = count1[0] - count2[0];
            result = dept[0] / 2;
        } else if (count1[1] > count2[1]) {
            dept[1] = count1[1] - count2[1];
            result = dept[1] / 2;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (dept[s1.charAt(i) - 'x'] > 0) {
                    dept[s1.charAt(i) - 'x']--;
                } else {
                    dept[s1.charAt(i) - 'x']++;
                    result++;

                }
            }
        }
        return result;
    }
}
