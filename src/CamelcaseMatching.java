import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public static void main(String[] args) {
        System.out.println(new CamelcaseMatching()
                .camelMatch(
                        new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}
                        , "FoBaT"
                ));
//        System.out.println(new CamelcaseMatching()
//                .camelMatch(
//                        new String[]{/*"aksvbjLiknuTzqon","ksvjLimflkpnTzqn","mmkasvjLiknTxzqn","ksvjLiurknTzzqbn","ksvsjLctikgnTzqn",*/"knzsvzjLiknTszqn"}
//        ,"ksvjLiknTzqn"
//                ));
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String s : queries) {
            boolean curR = true;
            int iCur = 0, iPat = 0;
            while (iCur < s.length() && iPat < pattern.length() && curR) {
                char chCur = s.charAt(iCur);
                char chPat = pattern.charAt(iPat);
                if (Character.isUpperCase(chCur)) {
                    curR = chCur == chPat;
                    iPat++;
                } else {
                    if (chCur == chPat)
                        iPat++;
                }
                iCur++;
            }
            if (iPat == pattern.length()) {
                while (curR && iCur < s.length()) {
                    if (Character.isUpperCase(s.charAt(iCur)))
                        curR = false;
                    iCur++;
                }
            } else {
                curR = false;
            }
            result.add(curR);
        }
        return result;
    }
}
