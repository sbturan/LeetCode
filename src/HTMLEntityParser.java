import java.util.HashMap;

public class HTMLEntityParser {
    public static void main(String[] args) {
        System.out.println(new HTMLEntityParser().entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }

    public String entityParser(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        map.put("&amp;", "&");
        StringBuilder sb = new StringBuilder();
        int i = 0, spStart = -1;
        while (i < text.length()) {
            char c = text.charAt(i);
            if (c == '&') {
                if (spStart > -1) {
                    sb.append(text.substring(spStart, i));
                }
                spStart = i;
            } else if (c == ';') {
                if (spStart > -1) {
                    String substring = text.substring(spStart, i + 1);
                    if (map.containsKey(substring)) {
                        sb.append(map.get(substring));
                    } else {
                        sb.append(substring);
                    }
                    spStart = -1;
                } else {
                    sb.append(c);
                }
            } else if (spStart < 0) {
                sb.append(c);
            }
            i++;
        }
        if (spStart > -1)
            sb.append(text.substring(spStart, text.length()));
        return sb.toString();
    }
}
