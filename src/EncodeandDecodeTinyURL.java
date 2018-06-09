import java.util.HashMap;

public class EncodeandDecodeTinyURL {
	public static void main(String[] args) {
		System.out.println("abc".hashCode());
		System.out.println("abcd".hashCode());
	}
	   // Encodes a URL to a shortened URL.
	HashMap <Integer,String> hashCodes=new HashMap<>();
    public String encode(String longUrl) {
    	int hashCode = longUrl.hashCode();
		hashCodes.put(hashCode, longUrl);
        return "http://tinyurl.com/"+hashCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int hashCode=Integer.valueOf(shortUrl.split("http://tinyurl.com/")[1]);
        return hashCodes.get(hashCode);
    }
}
