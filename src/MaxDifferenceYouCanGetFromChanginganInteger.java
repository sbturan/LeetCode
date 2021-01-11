public class MaxDifferenceYouCanGetFromChanginganInteger {
    public static void main(String[] args) {
        System.out.println(new MaxDifferenceYouCanGetFromChanginganInteger().maxDiff(111));
    }

    public int maxDiff(int num) {
        String numStr = Integer.toString(num);
        int digitCount = numStr.length();
        int result = 0;
        int indexFisrtNine = -1, indexFirstOne = numStr.charAt(0) != '1' ? 0 : -1;
        int i = 0;
        while (i < numStr.length() && (indexFisrtNine == -1 || indexFirstOne == -1)) {
            if (indexFisrtNine == -1 && numStr.charAt(i) != '9')
                indexFisrtNine = i;
            if (indexFirstOne == -1&& i>0 && numStr.charAt(i) != '0' && (numStr.charAt(0)!='1' || numStr.charAt(i)!='1'))
                indexFirstOne = i;
            i++;
        }
        if (indexFisrtNine == -1 ) {
            int t = (int) Math.pow(10, digitCount - 1);
            while (t > 0) {
                result += 8 * t;
                t /= 10;
            }
            return result;
        }
        char c = numStr.charAt(indexFisrtNine);
        int diff = '9' - c;
        result += diff * Math.pow(10, numStr.length() - 1 - indexFisrtNine);
        for (int j = indexFisrtNine + 1; j < numStr.length(); j++) {
            if (numStr.charAt(j) == c) {
                result += diff * Math.pow(10, numStr.length() - 1 - j);
            }
        }
        if(indexFirstOne>-1){
            char c2 = numStr.charAt(indexFirstOne);
            int diff2 = c2 - '0';
            if(indexFirstOne==0)
                diff2--;
            result += diff2 * Math.pow(10, numStr.length() - 1 - indexFirstOne);
            for (int j = indexFirstOne + 1; j < numStr.length(); j++) {
                if (numStr.charAt(j) == c2) {
                    result += diff2 * Math.pow(10, numStr.length() - 1 - j);
                }
            }
        }

        return result;
    }
}
