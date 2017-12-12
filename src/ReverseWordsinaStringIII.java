
public class ReverseWordsinaStringIII {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder result=new StringBuilder();
        for(String str:split) {
        	result.append(new StringBuilder(str).reverse()+" ");
        }
        
        return result.toString().trim();
    }
}
