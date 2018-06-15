import java.util.HashSet;

public class GoatLatin {
	
	public static void main(String[] args) {
		GoatLatin g=new GoatLatin();
		System.out.println(g.toGoatLatin("I speak Goat Latin"));
	}
	public String toGoatLatin(String S) {
         StringBuilder sb=new StringBuilder();;
         String[] split = S.split(" ");
         HashSet<Character>  vovels=new HashSet<>();
         vovels.add('a');
         vovels.add('e');
         vovels.add('i');
         vovels.add('o');
         vovels.add('u');
         
         for(int i=0;i<split.length;i++) {
        	 StringBuilder cur=new StringBuilder(split[i]);
        	 if(vovels.contains(Character.toLowerCase(cur.charAt(0)))) {
        		cur.append("ma");
        	 }else {
        		 cur.append(cur.charAt(0)+"ma");
        		 cur.deleteCharAt(0);
        	 }
        	 for(int j=0;j<i+1;j++) {
        		 cur.append("a");
        	 }
        	 sb.append(cur+" ");
         }
         sb.deleteCharAt(sb.length()-1);
         return sb.toString();
         
	}
}
